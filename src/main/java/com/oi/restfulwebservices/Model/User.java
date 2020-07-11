package com.oi.restfulwebservices.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@ApiModel(description = "Details of Users of Service")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class User {

  @Id
  @GeneratedValue
  @NonNull
  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 characters")
  @ApiModelProperty(notes = "Name should have at least 2 characters")
  @NonNull
  private String name;

  @Past
  @ApiModelProperty(notes = "Birth date must be in the past")
  @NonNull
  private Date birthDate;

  @OneToMany(mappedBy = "user")
  @NonNull
  private List<Post> posts;

  @NonNull
  private Integer id;

  @NonNull
  @Size(min = 2, message = "Name should have at least 2 characters")
  private String name;


  @NonNull
  @Past
  private Date birthDate;
  
}
