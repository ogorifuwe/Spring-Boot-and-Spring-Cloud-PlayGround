package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.User;
import com.oi.restfulwebservices.dao.UserDaoImpl;
import com.oi.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserDaoImpl service;

  @GetMapping("/users")
 public List<User> retrieveAllUsers() {
    return service.findAll();
 }

 // implement HATEOAS - Hypermedia As The Engine Of Application State
 @GetMapping("/users/{id}")
 public EntityModel<User> retrieveUser(@PathVariable int id) {
    User user = service.findOne(id);

    if (user == null) {
      throw new UserNotFoundException("User with id - " + id + " was not found");
    }

    // HATEOAS for retrieve all users
    EntityModel<User> resource = EntityModel.of(user);
    WebMvcLinkBuilder linkTo =
           WebMvcLinkBuilder
                   .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

    resource.add(linkTo.withRel("all-users"));
    return resource;
 }

 // input - details of user
  // output - CREATED (201) & the URI to Resource
 @PostMapping("/users")
 public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
    User savedUser = service.save(user);

    // CREATED
    // /user/{id} savedUser.getId()
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {

    User user = service.deleteUserById(id);

    if (user == null) {
      throw new UserNotFoundException("User with id - " + id + " was not found");
    }
  }

}
