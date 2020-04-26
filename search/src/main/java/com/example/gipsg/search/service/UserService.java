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
        switch (id) {
            case 1: return new User(1, "Shuya", "Japan", "12345678", "");
            case 2: return new User(2, "Nick", "Singapore", "44445555", "");
            case 3: return new User(3, "Shuwei", "China", "77778888", "");
            case 4: return new User(4, "David", "Sweden", "56785678", "");
            case 5: return new User(5, "Kinkoon", "Singapore", "12341234", "");
            case 6: return new User(6, "Pearlyn", "Singapore", "59595959", "");
            default: throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}