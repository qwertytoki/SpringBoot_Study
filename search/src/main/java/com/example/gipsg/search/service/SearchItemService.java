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

    public Map<String, String> getRadioItems() {
        Map<String, String> selectMap = new LinkedHashMap<String, String>();
        selectMap.put("1", "All");
        selectMap.put("2", "Japan");
        selectMap.put("3", "China");
        selectMap.put("4", "Singapore");
        selectMap.put("5", "Sweden");
        selectMap.put("6", "India");
        selectMap.put("7", "Belgium");
        return selectMap;
    }

    public List<String> getCheckItems() {
        List<String> checkItemList = new ArrayList<>();
        checkItemList.add("All");
        checkItemList.add("Singapore");
        checkItemList.add("Tokyo");
        return checkItemList;
    }
}