package dao;


import entity.User;

import java.util.List;

public interface UserRepository {
  List<User> listAll();
}
