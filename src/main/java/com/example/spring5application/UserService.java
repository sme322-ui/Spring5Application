package com.example.spring5application;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void updateEmailByName(String name,String email){
        userRepository.updateUserEmailByName(name,email);
    }

}
