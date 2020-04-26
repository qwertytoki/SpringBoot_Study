package com.example.gipsg.search.service;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ユーザー情報 Service
 */
@Service
public class SearchItemService {

    public Map<String,String> getRadioItems(){
        Map<String, String> selectMap = new LinkedHashMap<String, String>();
        selectMap.put("1", "ALL");
        selectMap.put("2", "Japanese");
        selectMap.put("3", "Chinese");
        selectMap.put("4", "Singaporean");
        selectMap.put("5", "Other");
        return selectMap;
    }
    public List<String> getCheckItems(){
        List<String> checkItemList= new ArrayList<>();
        checkItemList.add("Workout");
        return checkItemList;
    }
}