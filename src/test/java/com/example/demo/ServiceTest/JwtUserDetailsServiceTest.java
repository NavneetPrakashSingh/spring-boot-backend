package com.example.demo.ServiceTest;

import com.example.demo.businessLayer.service.jwt.JwtTokenUtil;
import com.example.demo.businessLayer.service.response.IResponse;
import com.example.demo.dataLayer.model.UserDTO;
import com.example.demo.businessLayer.service.jwt.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JwtUserDetailsServiceTest {


    @Autowired
    private JwtUserDetailsService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private UserDTO invalidUser;
    private UserDTO validUser;
    private UserDTO nullUser;
    private UserDTO badCredentials;
    private String token;
    private UserDetails userDetails;

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

        badCredentials = new UserDTO();
        badCredentials.setEmail("navneet@gmail.com");
        badCredentials.setFirstName("Navneet");
        badCredentials.setLastName("Singh");
        badCredentials.setUsername("Navneet");
        badCredentials.setPassword("navneet");

        nullUser = new UserDTO();

    }

    //    Integration test
    @Test
    public void stage1_testSaveValidUser() {
        IResponse response = service.save(validUser);
        assertEquals(response.getStatus(), "Success");
        token = response.getResponse();
    }

    @Test
    public void stage2_testValidLoadUserByUsername() {
        userDetails = service.loadUserByUsername("Navneet");
        assertEquals(userDetails.isEnabled(), true);
    }

    @Test
    public void stage3_testLoginMethodForCorrectUserDetails() {
        IResponse response = service.login(validUser);
        assertEquals(response.getStatus(),"Success");
    }

    @Test(expected = UsernameNotFoundException.class)
    public void stage4_testLoginMethodForIncorrectUserDetails() {
        service.login(invalidUser);
    }

    @Test(expected = BadCredentialsException.class)
    public void stage5_testLoginMethodForBadCredentials() {
        service.login(badCredentials);
    }

    @Test
    public void stage6_testDeleteValidUser() {
        UserDetails userDetails = service.loadUserByUsername("Navneet");
        String token = jwtTokenUtil.generateToken(userDetails);
        IResponse response = service.delete(validUser, token);
        assertEquals(response.getStatus(), "Success");
    }

    //Integration test ends here
    //Unit test starts here



    @Test(expected = UsernameNotFoundException.class)
    public void stage7_testLoadUserByUsername() {
        service.loadUserByUsername("navneet001");
    }


    @Test(expected = IllegalArgumentException.class)
    public void stage8_testSaveNullUser() {
        service.save(nullUser);
    }

    @Test
    public void stage9_testDeleteInvalidUser() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJOYXZuZWV0IiwiZXhwIjoxNTkxNDA5MzYzLCJpYXQiOjE1OTEzOTEzNjN9.zhTAzWHmcW99feCPccBQtI8tuwmlMk_wpy8f_11viZ9-0f8Kn7BV35cY7EiJdA3fErcaW49g7CmKso7R_Loavg";
        try {
            service.delete(invalidUser, token);
        } catch (ExpiredJwtException ex) {
            assertEquals(ex.getClaims().size(), 3);
        } catch (UsernameNotFoundException ex) {
            assertEquals(ex.getClass(), UsernameNotFoundException.class);
        }
    }


}
