package com.example.userdatabase.api.controller;

import java.util.List;

import com.example.userdatabase.api.entity.UserEntity;
import com.example.userdatabase.api.model.User;
import com.example.userdatabase.api.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "getallusers",method =RequestMethod.GET)
   public List<User>getAllUsers(){
       return userService.getAllUsers();
   }
   @RequestMapping(value = "adduser",method = RequestMethod.POST)
   public String addUser(@RequestBody UserEntity user){
    return userService.addUser(user);
   }
   @RequestMapping(value = "updateuser",method = RequestMethod.PUT)
   public String updateUser(@RequestBody UserEntity user){
       return userService.updateUser(user);
   }
   @RequestMapping(value="removeuser",method = RequestMethod.DELETE)
   public String removeUser(@RequestBody UserEntity user){
       return userService.removeUser(user);
   }
    
}
