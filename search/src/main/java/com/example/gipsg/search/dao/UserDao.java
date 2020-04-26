package com.example.gipsg.search.dao;

import com.example.gipsg.search.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    @Autowired
    HttpSession session;

    protected List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Shuya", "Japan", "12345678", "");
        User user2 = new User(2, "Nook", "Singapore", "44445555", "");
        User user3 = new User(3, "Sowei", "China", "77778888", "");
        User user4 = new User(4, "Dave", "Sweden", "56785678", "");
        User user5 = new User(5, "Kick", "Singapore", "12341234", "");
        User user6 = new User(6, "Pearl", "Singapore", "59595959", "");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        return userList;
    }

    protected List<User> getUsers(){
        session.getAttribute("userDB");
    }

    protected List<User> saveUsers(List<User> userList){
        session.setAttribute("userDB", userList);
    }
}
