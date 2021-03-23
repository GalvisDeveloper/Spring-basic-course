package com.bolsadeideas.springboot.web.app.section2.controllers;

import com.bolsadeideas.springboot.web.app.section2.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Index page");
        return "index/index";
    }

    @GetMapping({"/user","/profile"})
    public String perfil(Model model){
        model.addAttribute("title", "Profile detail");
        User user = new User();
        user.setName("Cristian");
        user.setSecond_name("Bustos");
        /*user.setEmail("cristian@test.com");*/
        model.addAttribute("profile", user);
        return "index/profile";
    }

    @GetMapping({"/users","/list"})
    public String list(Model model){
        model.addAttribute("title", "List of users");
//        model.addAttribute("users", this.addUsers());
        return "index/list";
    }

    @ModelAttribute("users")
    public List<User> addUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Zoe", "Roberts", "zoe.roberts@example.com"));
        users.add(new User("Todd", "Chambers", "todd.chambers@example.com"));
        users.add(new User("Daisy", "Fernandez", "daisy.fernandez@example.com"));
        return users;
    }

}
