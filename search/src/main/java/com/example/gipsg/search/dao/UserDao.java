package com.example.gipsg.search.dao;

import com.example.gipsg.search.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDao {

    @Autowired
    HttpSession session;

    public List<User> getUsers() {
        Object userList = session.getAttribute("userDB");
        if (Objects.isNull(userList)) {
            userList = getAllUser();
        }
        return (List<User>) userList;
    }

    public void saveUsers(List<User> userList) {
        session.setAttribute("userDB", userList);
    }

    private List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        User user1 = new User("1", "Shuya", "Japan", "Singapore", "Workout");
        User user2 = new User("2", "Nook", "Singapore", "Singapore", "");
        User user3 = new User("3", "Sowei", "China", "Singapore", "");
        User user4 = new User("4", "Dave", "Sweden", "Singapore", "");
        User user5 = new User("5", "Kick", "Singapore", "Singapore", "");
        User user6 = new User("6", "Pearl", "Singapore", "Singapore", "");
        User user7 = new User("7", "Shira", "Japan", "Tokyo", "");
        User user8 = new User("8", "Alex", "Belgium", "Tokyo", "");
        User user9 = new User("9", "Neehaa", "India", "Tokyo", "");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        return userList;
    }
}
