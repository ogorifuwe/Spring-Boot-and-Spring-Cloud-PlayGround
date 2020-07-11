package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.Post;
import com.oi.restfulwebservices.Model.User;
import com.oi.restfulwebservices.dao.PostRepository;
import com.oi.restfulwebservices.dao.UserRepository;
import com.oi.restfulwebservices.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserJPAController.class);

  @GetMapping("/jpa/users")
 public List<User> retrieveAllUsers() {
    return userRepository.findAll();
 }

 // implement HATEOAS - Hypermedia As The Engine Of Application State
 @GetMapping("/jpa/users/{id}")
 public EntityModel<User> retrieveUser(@PathVariable int id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("User with id - " + id + " was not found");
    }

    // HATEOAS link for retrieve all users
    EntityModel<User> resource = EntityModel.of(userOptional.get());
    WebMvcLinkBuilder linkTo =
           WebMvcLinkBuilder
                   .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

    resource.add(linkTo.withRel("all-users"));
    return resource;
 }

 // input - details of user
  // output - CREATED (201) & the URI to Resource
 @PostMapping("/jpa/users")
 public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
    User savedUser = userRepository.save(user);

    // CREATED
    // /user/{id} savedUser.getId()
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {

    userRepository.deleteById(id);
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> getUserPosts(@PathVariable int id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("User with id - " + id + " was not found");
    }

    return userOptional.get().getPosts();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("User with id - " + id + " was not found");
    }

    User user = userOptional.get();
    post.setUser(user);
    Post savedPost = postRepository.save(post);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedPost.getId()).toUri();

    return ResponseEntity.created(location).build();
  }



}
