package com.oi.restfulwebservices.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Student {

  @NonNull
  private int id;

  @JsonIgnore
  @NonNull
  private String name;

  @JsonIgnore
  @NonNull
  private String major;
}
