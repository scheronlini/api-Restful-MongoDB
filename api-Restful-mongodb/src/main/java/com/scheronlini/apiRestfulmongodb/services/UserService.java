package com.scheronlini.apiRestfulmongodb.services;

import com.scheronlini.apiRestfulmongodb.domain.User;
import com.scheronlini.apiRestfulmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }

}
