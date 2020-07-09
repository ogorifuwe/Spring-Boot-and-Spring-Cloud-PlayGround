package com.oi.restfulwebservices.controller;

import com.oi.restfulwebservices.Model.Name;
import com.oi.restfulwebservices.Model.PersonV1;
import com.oi.restfulwebservices.Model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

  // URI VERSIONING
  @GetMapping("/person/v1")
  public PersonV1 getPersonV1() {
    return new PersonV1("Ogor Ifuwe");
  }

  @GetMapping("/person/v2")
  public PersonV2 getPersonV2() {
    return new PersonV2(new Name("Ogor", "Ifuwe"));
  }

  // REQUEST PARAMETER VERSIONING
  @GetMapping(value = "/person/param", params = "version=1")
  public PersonV1 paramV1() {
    return new PersonV1("Ogor Ifuwe");
  }

  @GetMapping(value = "/person/param", params = "version=2")
  public PersonV2 paramV2() {
    return new PersonV2(new Name("Ogor", "Ifuwe"));
  }

  // HEADER VERSIONING
  @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
  public PersonV1 headerV1() {
    return new PersonV1("Ogor Ifuwe");
  }

  @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
  public PersonV2 headerV2() {
    return new PersonV2(new Name("Ogor", "Ifuwe"));
  }

  // MIME TYPE VERSIONING OR ACCEPT HEADER VERSIONING
  @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
  public PersonV1 producesV1() {
    return new PersonV1("Ogor Ifuwe");
  }

  @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
  public PersonV2 producesV2() {
    return new PersonV2(new Name("Ogor", "Ifuwe"));
  }
}
