package com.example.gipsg.search.service;

import com.example.gipsg.search.dao.UserDao;
import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
public class ViewService {
    @Autowired
    UserDao userDao;

    public List<String> getHobbies(){
        List<String> hobbyList= new ArrayList<>();
        hobbyList.add("Workout");
        hobbyList.add("Buffet");
        hobbyList.add("Drama");
        return hobbyList;
    }
    public List<User> updateUserInfo(User updUser){
        List<User> userList = new ArrayList<>();
        for(User user : userDao.getUsers()){
            if(user.getId().equals(updUser.getId())){
                userList.add(updUser);
            }else{
                userList.add(user);
            }
        }
        userDao.saveUsers(userList);
        return userList;
    }
}