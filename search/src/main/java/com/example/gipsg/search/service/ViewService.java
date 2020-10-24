package com.example.gipsg.search.service;

import com.example.gipsg.search.dao.ProfileDao;
import com.example.gipsg.search.dao.UserDao;
import com.example.gipsg.search.dto.AnswerOptionsDto;
import com.example.gipsg.search.dto.ProfileGroupInfoDto;
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

    @Autowired
    ProfileDao profileDao;

    public List<String> getHobbies(String selectedHobbies) {
        String[] hobbyArray = {""};
        if (!StringUtils.isEmpty(selectedHobbies)) {
            hobbyArray = selectedHobbies.split(",");
        }
        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("Workout");
        hobbyList.add("Buffet");
        hobbyList.add("KoreanDrama");
        List<String> filteredHobbyList = new ArrayList<>();
        for (String hobby : hobbyList) {
            boolean isSelected = false;
            for (String selectedHobby : hobbyArray) {
                if (selectedHobby.equals(hobby)) {
                    isSelected = true;
                }
            }
            if (!isSelected) filteredHobbyList.add(hobby);
        }
        return filteredHobbyList;
    }

    public List<User> updateUserInfo(User updUser) {
        List<User> userList = new ArrayList<>();
        for (User user : userDao.getUsers()) {
            if (user.getId().equals(updUser.getId())) {
                userList.add(updUser);
            } else {
                userList.add(user);
            }
        }
        userDao.saveUsers(userList);
        return userList;
    }

    public List<ProfileGroupInfoDto> getPUSQuestionsById(String id) {
        List<ProfileGroupInfoDto> questionList = profileDao.getProfilesById(id);
        return questionList;
    }
}