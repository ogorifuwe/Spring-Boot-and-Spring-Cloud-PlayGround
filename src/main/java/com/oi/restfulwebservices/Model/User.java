package com.oi.restfulwebservices.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Details of Users of Service")
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
  @ApiModelProperty(notes = "Name should have at least 2 characters")
  private String name;


  @NonNull
  @Past
  @ApiModelProperty(notes = "Birth date must be in the past")
  private Date birthDate;
}
