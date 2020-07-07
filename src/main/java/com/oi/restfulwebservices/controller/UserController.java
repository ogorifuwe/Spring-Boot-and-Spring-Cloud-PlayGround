package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.User;
import com.oi.restfulwebservices.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserDaoImpl service;

  @GetMapping("/users")
 public List<User> retrieveAllUsers() {
    return service.findAll();
 }

 @GetMapping("/users/{id}")
 public User retrieveUser(@PathVariable int id) {
    return service.findOne(id);
 }

 // input - details of user
  // output - CREATED (201) & the URI to Resource
 @PostMapping("/users")
  public void createUser(@RequestBody User user) {
    User savedUser = service.save(user);
 }


}
