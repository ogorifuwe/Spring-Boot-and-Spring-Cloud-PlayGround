package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public Student retrieveStudent() {
    return new Student(0001, "Ogor Ifuwe", "Comp Sci");
  }

  @GetMapping("/filtering-list")
  public List<Student> retrieveStudentList() {
    List<Student> students =  Arrays.asList(
            new Student(0001, "Ogor Ifuwe", "Comp Sci"),
            new Student(0002, "Zik Hommes", "Elect Engr")

    );

    return students;
  }


}
