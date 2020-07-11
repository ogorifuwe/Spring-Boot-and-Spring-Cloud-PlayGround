package com.oi.restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.oi.restfulwebservices.Model.Student;
import com.oi.restfulwebservices.Model.Student2;
import org.springframework.http.converter.json.MappingJacksonValue;
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

  /**
   * @return Filtered version of Student Bean by using MappingJacksonValue to
   * implement dynamic filtering
   */
  @GetMapping("/filtering-dynamic")
  public MappingJacksonValue retrieveStudent2() {
    Student2 student = new  Student2(0001, "Ogor Ifuwe", "Comp Sci");

    SimpleBeanPropertyFilter filter =
            SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

    return filterObject(student, filter);
  }


  @GetMapping("/filtering-dynamic-list")
  public MappingJacksonValue retrieveStudentList2() {
    List<Student2> students =  Arrays.asList(
            new Student2(0001, "Ogor Ifuwe", "Comp Sci"),
            new Student2(0002, "Zik Hommes", "Elect Engr")

    );

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "major");
    return filterObject(students, filter);
  }


  private MappingJacksonValue filterObject(Object o, SimpleBeanPropertyFilter filter) {

    FilterProvider filters =
            new SimpleFilterProvider().addFilter("StudentFilter", filter);
    MappingJacksonValue mapping = new MappingJacksonValue(o);
    mapping.setFilters(filters);

    return mapping;

  }

}
