package com.example.gipsg.search.service;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
public class ViewService {
    public List<String> getHobbies(){
        List<String> hobbyList= new ArrayList<>();
        hobbyList.add("Workout");
        hobbyList.add("Buffet");
        hobbyList.add("Drama");
        return hobbyList;
    }
}