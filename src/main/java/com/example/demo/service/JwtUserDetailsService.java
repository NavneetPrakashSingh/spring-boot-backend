package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.dao.UserDao;
import com.example.demo.model.DAOUser;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public JwtResponse save(UserDTO user) throws UsernameNotFoundException {

        DAOUser doesUserExists = userDao.findByEmail(user.getEmail());
        if (doesUserExists != null) {
            throw new UsernameNotFoundException("User alread exists");
        } else {

            DAOUser newUser = new DAOUser();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail(user.getEmail());
            DAOUser validateIfUserIsSaved = userDao.save(newUser);
            if (validateIfUserIsSaved != null) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                final String token = jwtTokenUtil.generateToken(userDetails);
                return new JwtResponse(token);
            } else {
                throw new UsernameNotFoundException("User already exists");
            }
        }
    }

    public JwtResponse login(UserDTO user) {
        DAOUser userExists = userDao.findByEmail(user.getEmail());
        //decrypt password and match it with the user entered password
        if (userExists != null) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(userExists.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return new JwtResponse(token);
        } else {
            throw new UsernameNotFoundException("User Doesn't exists");
        }
    }
}