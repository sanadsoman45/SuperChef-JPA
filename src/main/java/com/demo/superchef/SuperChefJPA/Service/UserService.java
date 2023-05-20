package com.demo.superchef.SuperChefJPA.Service;

import com.demo.superchef.SuperChefJPA.Entities.FavRecipes;
import com.demo.superchef.SuperChefJPA.Entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    HashMap<String,String> getUserByEmailId(String emailid);

    boolean deleteUser(String emailid);

    boolean checkUserByEmailId(String emailId);

    int updateUser(User user, String emailid);

    String loginUser(String emailid, String passwd);



}
