package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

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

 @GetMapping(path = "/hello-world-internationalized")
  public String helloWorldInternationalized(
          @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
    return messageSource.getMessage("good.morning.message", null, locale);
  }

  @GetMapping(path = "/hello-world-internationalized-improved")
  public String helloWorldInternationalizedImproved() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }
}
