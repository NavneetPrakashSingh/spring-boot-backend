package com.example.demo.ServiceTest;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.datalayer.response.IResponse;
import com.example.demo.datalayer.response.JwtResponse;
import com.example.demo.datalayer.model.UserDTO;
import com.example.demo.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUserDetailsServiceTest {


    @Autowired
    private JwtUserDetailsService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private UserDTO invalidUser;
    private UserDTO validUser;
    private UserDTO nullUser;

    @Before
    public void setup() {
        invalidUser = new UserDTO();
        invalidUser.setEmail("navneet10101@gmail.com");
        invalidUser.setFirstName("Navneet01");
        invalidUser.setLastName("Singh");
        invalidUser.setUsername("navneet0101");
        invalidUser.setPassword("password");

        validUser = new UserDTO();
        validUser.setEmail("navneet@gmail.com");
        validUser.setFirstName("Navneet");
        validUser.setLastName("Singh");
        validUser.setUsername("Navneet");
        validUser.setPassword("password");

        nullUser = new UserDTO();

    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoginMethodForIncorrectUserDetails() {
        System.out.println(service.login(invalidUser));
    }

    @Test
    public void testLoginMethodForCorrectUserDetails() {
        IResponse response = service.login(validUser);
        UserDetails details = service.loadUserByUsername(validUser.getUsername());
        assertEquals(jwtTokenUtil.validateToken(response.getResponse(), details), true);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsername() {
        service.loadUserByUsername("navneet001");
    }

    @Test
    public void testValidLoadUserByUsername() {
        UserDetails userDetails = service.loadUserByUsername("Navneet");
        assertEquals(userDetails.isEnabled(), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNullUser() {
        service.save(nullUser);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testInvalidUser() {
        service.save(validUser);
    }

    @Test
    public void testDeleteInvalidUser() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJOYXZuZWV0IiwiZXhwIjoxNTkxNDA5MzYzLCJpYXQiOjE1OTEzOTEzNjN9.zhTAzWHmcW99feCPccBQtI8tuwmlMk_wpy8f_11viZ9-0f8Kn7BV35cY7EiJdA3fErcaW49g7CmKso7R_Loavg";
        try {
            service.delete(invalidUser, token);
        } catch (ExpiredJwtException ex) {
            assertEquals(ex.getClaims().size(), 3);
        } catch (UsernameNotFoundException ex) {
            assertEquals(ex.getClass(), UsernameNotFoundException.class);
        }
    }

    @Test
    public void testDeleteValidUser() { 
//        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJOYXZuZWV0IiwiZXhwIjoxNTkxNDA5MzYzLCJpYXQiOjE1OTEzOTEzNjN9.zhTAzWHmcW99feCPccBQtI8tuwmlMk_wpy8f_11viZ9-0f8Kn7BV35cY7EiJdA3fErcaW49g7CmKso7R_Loavg";
//        IResponse response = service.delete(validUser, token);
//        assertEquals(response.getStatus(), "Success");
    }

    @Test
    public void testSaveValidUser() {
        assertEquals(service.save(validUser).getStatus(), "Success");
    }


}
