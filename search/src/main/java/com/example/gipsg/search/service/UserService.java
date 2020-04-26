package com.example.gipsg.search.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import com.example.gipsg.search.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService{
    private User user1 = new User(1,"Shuya","Japan","12345678" ,"");
    private User user2 = new User(2,"Nook","Singapore","44445555","");
    private User user3 = new User(3,"Sowei","China","77778888","");
    private User user4 = new User(4,"Dave","Sweden","56785678","");
    private User user5 = new User(5,"Kick","Singapore","12341234","");
    private User user6 = new User(6,"Pearl","Singapore","59595959","");

    public List<User> search(Search search) {
        String name = search.getName();
        if(!StringUtils.isEmpty(name) && name.equalsIgnoreCase("shu")){
            return searchNameS();
        }
        String nationality = search.getNationality();
        if(!StringUtils.isEmpty(nationality) && nationality.equalsIgnoreCase("4")){
            return searchSingaporean();
        }

        return searchAll();
    }
    private List<User> searchNameS() {
        List<User> userList = new ArrayList();
        userList.add(user1);
        userList.add(user3);
        return userList;
    }

    private List<User> searchSingaporean() {
        List<User> userList = new ArrayList();
        userList.add(user2);
        userList.add(user5);
        userList.add(user6);
        return userList;
    }

    private List<User> searchAll() {
        List<User> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        return userList;
    }

    public User findById(int id) {
        switch(id){
            case 1:
                return new User(1,"Shuya","Japan","12345678","");
            case 2:
                return new User(2,"Nick","Singapore","44445555","");
            case 3:
                return new User(3,"Shuwei","China","77778888","");
            case 4:
                return new User(4,"David","Sweden","56785678","");
            case 5:
                return new User(5,"Kinkoon","Singapore","12341234","");
            case 6:
                return new User(6,"Pearlyn","Singapore","59595959","");
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}