package com.example.demo.dataLayer.dao;

import com.example.demo.dataLayer.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
    DAOUser findByEmail(String email);
}