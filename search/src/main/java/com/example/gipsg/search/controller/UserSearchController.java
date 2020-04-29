package com.example.gipsg.search.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import com.example.gipsg.search.service.SearchItemService;
import com.example.gipsg.search.service.UserSearchService;
import com.example.gipsg.search.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserSearchController {

    @Autowired
    private UserSearchService userSearchService;
    @Autowired
    private SearchItemService searchItemService;
    @Autowired
    private ViewService viewService;

    @RequestMapping("/user/list")
    public String displayList(@ModelAttribute("search") Search search, Model model) {
        List<User> userList = userSearchService.search(search);
        model.addAttribute("search", search);
        model.addAttribute("userlist", userList);
        model.addAttribute("radioItems", searchItemService.getRadioItems());
        model.addAttribute("checkItems", searchItemService.getCheckItems());
        return "user/list";
    }

    @RequestMapping("/user/{id}")
    public String displayView(@PathVariable String id, @ModelAttribute("user") User user, Model model) {
        if(user.getName()!=null){
            viewService.updateUserInfo(user);
        }else{
            user = userSearchService.findById(id);
        }
        model.addAttribute("user", user);
        return "user/view";
    }

    @RequestMapping("/user/{id}/edit")
    public String displayEdit(@PathVariable String id, Model model) {
        User user = userSearchService.findById(id);
        model.addAttribute("user", user);
        Map<String, String> radioItemMap = searchItemService.getRadioItems();
        radioItemMap.remove("1");
        model.addAttribute("radioItems", radioItemMap);
        List<String> checkItemList = searchItemService.getCheckItems();
        checkItemList.remove(0);
        model.addAttribute("checkItems", checkItemList);
        model.addAttribute("hobbies", viewService.getHobbies(user.getHobby()));
        if(!StringUtils.isEmpty(user.getHobby())){
            List<String> selectedHobbies = Arrays.asList(user.getHobby().split(","));
            model.addAttribute("selectedHobbies", selectedHobbies);
        }
        return "user/edit_view";
    }
}
