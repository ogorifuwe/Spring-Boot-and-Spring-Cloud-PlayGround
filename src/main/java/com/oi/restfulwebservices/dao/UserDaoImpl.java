package com.oi.restfulwebservices.dao;

import com.oi.restfulwebservices.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoImpl {

  private static List<User> users = new ArrayList<>();

  private static int userCounts = 3;

  static {
    users.add(new User(1, "Adam", new Date()));
    users.add(new User(2, "Eve", new Date()));
    users.add(new User(3, "Jack", new Date()));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user) {

    if (user.getId() == null) {
      user.setId(++userCounts);
    }

    users.add(user);
    return user;
  }

  public User findOne(int id) {

    User currUser = null;

    for (User user: users) {
      if (user.getId() == id) {
        currUser = user;
        break;
      }
    }

    return currUser;
  }
}
