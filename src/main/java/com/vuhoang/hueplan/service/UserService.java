package com.vuhoang.hueplan.service;

import com.vuhoang.hueplan.entity.UserEntity;
import com.vuhoang.hueplan.interfaces.I_User;
import com.vuhoang.hueplan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements I_User {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUser(int userID) {
        return userRepository.getReferenceById(userID);
    }

    @Override
    public List<UserEntity> getAllUser() {
        System.out.println("API getAllUser được gọi!");
        return userRepository.findAll();
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public int updateUser(UserEntity user) {
        return userRepository.findById(user.getUser_ID())
                .map(existingUser -> {
                    existingUser.setUser_Name(user.getUser_Name());
                    existingUser.setUser_Email(user.getUser_Email());
                    existingUser.setUser_Password(user.getUser_Password());
                    return userRepository.save(existingUser).getUser_ID(); // Lưu user đã cập nhật
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user.getUser_ID()));
    }

    @Override
    public boolean deleteUser(int userID) {
        if (userRepository.existsById(userID)) {
            userRepository.deleteById(userID);
            return true;
        }
        return false;
    }
}
