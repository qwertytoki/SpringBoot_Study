package com.example.gipsg.search.controller;

import com.example.gipsg.search.dto.ProfileGroupInfoDto;
import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import com.example.gipsg.search.service.SearchItemService;
import com.example.gipsg.search.service.UserSearchService;
import com.example.gipsg.search.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class ProfileController {

    @Autowired
    private UserSearchService userSearchService;
    @Autowired
    private SearchItemService searchItemService;
    @Autowired
    private ViewService viewService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/profile/list")
    public String displayList(@ModelAttribute("search") Search search, Model model) {
        List<User> userList = userSearchService.search(search);
        model.addAttribute("search", search);
        model.addAttribute("userlist", userList);
        model.addAttribute("radioItems", searchItemService.getRadioItems());
        model.addAttribute("checkItems", searchItemService.getCheckItems());
        return "profile/list";
    }

    @RequestMapping("/profile/{id}")
    public String displayView(@PathVariable String id, Model model) {
        List<ProfileGroupInfoDto> questionList = viewService.getPUSQuestionsById(id);
        model.addAttribute("questionList", questionList);
//        if(user.getName()!=null){
//            viewService.updateUserInfo(user);
//        }else{
//            user = userSearchService.findById(id);
//        }
//        model.addAttribute("user", user);
        return "profile/list";
    }

    @RequestMapping("/profile/{id}/edit")
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
        return "profile/edit_view";
    }
}
