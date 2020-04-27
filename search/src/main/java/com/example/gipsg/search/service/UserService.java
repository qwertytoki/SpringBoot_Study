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
    @Autowired
    private SearchItemService searchItemService;

    public List<User> search(Search search) {
        List<User> userList = searchAll();
        String name = search.getName();
        if (!StringUtils.isEmpty(name)) {
            userList = searchByName(name, userList);
        }
        String nationalityId = search.getNationality();
        if (!StringUtils.isEmpty(nationalityId)) {
            userList = searchByNationality(nationalityId, userList);
        }
        return userList;
    }

    private List<User> searchByName(String searchWord, List<User> userList) {
        List<User> searchedList = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(searchWord.toLowerCase())) {
                searchedList.add(user);
            }
        }
        return searchedList;
    }

    private List<User> searchByNationality(String nationalityId, List<User> userList) {
        List<User> searchedList = new ArrayList<>();
        String nationality = searchItemService.getRadioItems().get(nationalityId);
        for (User user : userList) {
            if(user.getNationality().equalsIgnoreCase(nationality)){
                searchedList.add(user);
            }
        }
        return searchedList;
    }

    private List<User> searchAll() {
        return userDao.getUsers();
    }

    public User findById(int id) {
        List<User> userList = userDao.getUsers();
        for (User user : userList) {
            if (user.getId() == id) return user;
        }
        throw new IllegalArgumentException("Parameter's id is not exist. id:" + id);
    }
}