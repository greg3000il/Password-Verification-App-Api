package com.example.userdatabase.api.service;

import java.util.ArrayList;
import java.util.List;

import com.example.userdatabase.api.entity.UserEntity;
import com.example.userdatabase.api.model.User;
import com.example.userdatabase.api.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User>getAllUsers(){
        try{
            List<UserEntity>users=userRepository.findAll();
            List<User>customUsers=new ArrayList<>();
            users.stream().forEach(e->{
                User user =new User();
                BeanUtils.copyProperties(e, user);
                customUsers.add(user);
            });
            return customUsers;
        }catch(Exception e){
            throw e;
        }
    }
    public String addUser(UserEntity user){
        try{
            if(!userRepository.existsByUsernameAndPassword(user.getUsername(),user.getPassword())){
                userRepository.save(user); 
                return "User added successfully";
            }
            else
                return "This user already exists in the database";
        }catch(Exception e){
            throw e;
        }
    }
    public String removeUser(UserEntity user){
        try{
            if(userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())){
                userRepository.delete(user); 
                return "User removed successfully";
            }
            else
                return "This user does not exists in the database";
        }catch(Exception e){
            throw e;
        }
    }
    public String updateUser(UserEntity user){
        try{
            if(userRepository.existsById(user.getId())){
                userRepository.save(user); 
                return "User updated successfully";
            }
            else
                return "This user does not exists in the database";
        }catch(Exception e){
            throw e;
        }
    }
}
