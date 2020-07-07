package com.oi.restfulwebservices.Model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor()
@Getter
@Setter
@ToString
public class HelloWorldBean {

  @NonNull
  private String message;


}
