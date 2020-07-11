package com.oi.restfulwebservices.Model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Name {

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;
}
