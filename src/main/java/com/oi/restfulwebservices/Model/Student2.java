package com.oi.restfulwebservices.Model;
/**
 * Used to demonstrates Dynamic Filtering of iVars using
 * @See FilteringController.class for implementation
 */

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@JsonFilter("StudentFilter")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Student2 {

  @NonNull
  private int id;

  @NonNull
  private String name;

  @NonNull
  private String major;
}
