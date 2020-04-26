package com.example.gipsg.search.controller;

import java.util.List;

import com.example.gipsg.search.entity.Search;
import com.example.gipsg.search.entity.User;
import com.example.gipsg.search.service.SearchItemService;
import com.example.gipsg.search.service.UserService;
import com.example.gipsg.search.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SearchItemService searchItemService;
    @Autowired
    private ViewService viewService;

    @RequestMapping("/user/list")
    public String displayList(@ModelAttribute("search") Search search, Model model) {
        List<User> userlist = userService.search(search);
        model.addAttribute("search", search);
        model.addAttribute("userlist", userlist);
        model.addAttribute("radioItems", searchItemService.getRadioItems());
        model.addAttribute("checkItems", searchItemService.getCheckItems());
        return "user/list";
    }

    @RequestMapping("/user/{id}")
    public String displayView(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("hobbies", viewService.getHobbies());
        return "user/view";
    }
}
