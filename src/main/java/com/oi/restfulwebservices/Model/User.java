package com.oi.restfulwebservices.Model;

import lombok.*;

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
  private String name;

  @NonNull
  private Date birthDate;
}
