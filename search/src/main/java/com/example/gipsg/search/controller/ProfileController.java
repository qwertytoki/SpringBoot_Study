package com.example.gipsg.search.controller;

import com.example.gipsg.search.dto.ProfileGroupInfoDto;
import com.example.gipsg.search.entity.Profile;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    private List<ProfileGroupInfoDto> questionList;

    @RequestMapping("/profile/list")
    public String displayList(@ModelAttribute("profile") Profile profile, Model model, @RequestParam("id") String id) {
        if(id == null){
            id = "1";
        }
        questionList = viewService.getPUSQuestionsById(id);
        model.addAttribute("questionList", questionList);
        model.addAttribute("checkItems", searchItemService.getCheckItems());
        return "profile/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String input(
            @Valid @ModelAttribute("profile") Profile profile,
            Model model, HttpServletRequest request) {
        questionList =  validate(profile);
        model.addAttribute("questionList", questionList);
        return "profile/list";
    }

    private List<ProfileGroupInfoDto> validate(Profile profile) {
        questionList.get(0).setIsError(true);
        return questionList;
    }

    @RequestMapping("/profile/{id}")
    public String displayView(@PathVariable String id, @ModelAttribute("user") User user, Model model) {
        if(user.getName()!=null){
            viewService.updateUserInfo(user);
        }else{
            user = userSearchService.findById(id);
        }
        model.addAttribute("user", user);
        return "user/view";
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
