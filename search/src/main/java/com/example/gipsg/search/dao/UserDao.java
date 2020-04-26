package com.example.gipsg.search.dao;

import com.example.gipsg.search.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    protected List<User> getAllUser(){
        return generateSampleUser();
    }
    private List<User> generateSampleUser(){
        User user1 = new User(1,"shuya","Japan","12345678","");
        User user2 = new User(2,"nick","Singapore","44445555","");
        User user3 = new User(3,"shuwei","China","77778888","");
        List<User> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
