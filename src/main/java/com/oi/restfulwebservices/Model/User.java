package com.oi.restfulwebservices.Model;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class User {

  @NonNull
  private Integer id;

  @NonNull
  @Size(min = 2, message = "Name should have at least 2 characters")
  private String name;


  @NonNull
  @Past
  private Date birthDate;
}
