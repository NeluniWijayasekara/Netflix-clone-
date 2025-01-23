package com.example.Netflix.service;

import com.example.Netflix.model.User;
import com.example.Netflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    User saveUser(User User);
    List<User> getAllUser();
    User getUserById(long id);
    User updateUser(User User,long id);
    void deleteUser(long id);

    User getUserByEmail(String email);

}