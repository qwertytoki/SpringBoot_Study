package com.example.gipsg.search.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import com.example.gipsg.search.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> search(Search search) {
        String name = search.getName();
        if (!StringUtils.isEmpty(name) && name.equalsIgnoreCase("shu")) {
            return searchNameS();
        }
        String nationality = search.getNationality();
        if (!StringUtils.isEmpty(nationality) && nationality.equalsIgnoreCase("4")) {
            return searchSingaporean();
        }
        return searchAll();
    }

    private List<User> searchNameS() {
        userDao.getUsers();
        List<User> userList = userDao.getUsers();
        return userList;
    }

    private List<User> searchSingaporean() {
        List<User> userList = userDao.getUsers();
        return userList;
    }

    private List<User> searchAll() {
        return userDao.getUsers();
    }

    public User findById(int id) {
        List<User> userList = userDao.getUsers();
        for(User user:userList){
            if(user.getId()==id)return user;
        }
        throw new IllegalArgumentException("Parameter's id is not exist. id:"+id);
    }
}