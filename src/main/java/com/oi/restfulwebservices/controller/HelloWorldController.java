package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello, World!";
  }


  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello, World!");
  }

  @GetMapping(path = "/hello-world-bean/path-variable/{name}")
  public HelloWorldBean helloPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello, %s!", name));
  }
}
