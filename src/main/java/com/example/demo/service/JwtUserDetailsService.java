package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.datalayer.dao.UserDao;
import com.example.demo.datalayer.model.DAOUser;
import com.example.demo.datalayer.response.IResponse;
import com.example.demo.datalayer.response.JwtResponse;
import com.example.demo.datalayer.model.UserDTO;
import com.example.demo.datalayer.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public IResponse save(UserDTO user) throws UsernameNotFoundException {

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
//                return new JwtResponse(token);
                IResponse response = new ResponseMessage();
                response.setStatus("Success");
                response.setResponse(token);
                return response;
            } else {
                throw new UsernameNotFoundException("User already exists");
            }
        }
    }

    public IResponse login(UserDTO user) {
        DAOUser userExists = userDao.findByEmail(user.getEmail());
        if (userExists != null) {
            if(bcryptEncoder.matches(user.getPassword(),userExists.getPassword())) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(userExists.getUsername());
                final String token = jwtTokenUtil.generateToken(userDetails);
                IResponse response = new ResponseMessage();
                response.setResponse(token);
                response.setStatus("Success");
                return response;
            }else {
                throw new BadCredentialsException("Invalid credentials");
            }
        } else {
            throw new UsernameNotFoundException("User Doesn't exists");
        }
    }

    public IResponse delete(UserDTO user, String token) {
        DAOUser userExists = userDao.findByEmail(user.getEmail());
        if (userExists != null) {
            UserDetails userDetails = loadUserByUsername(userExists.getUsername());
            boolean validToken = jwtTokenUtil.validateToken(token, userDetails);
            if (validToken) {
                userDao.deleteById(userExists.getId());
                IResponse success = new ResponseMessage();
                success.setStatus("Success");
                success.setResponse("User Deleted Successfully");
                return success;
            } else {
                throw new UsernameNotFoundException("Token is invalid");
            }
        } else {
            throw new UsernameNotFoundException("User Doesn't exists");
        }

    }

}