package com.bolsadeideas.springboot.web.app.section2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vars")
public class PathController {

    @GetMapping({"/index", "", "/", "/home"})
    public String index(Model model){
        model.addAttribute("title", "Path Index Page");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String vars(@PathVariable String text, Model model) {
        model.addAttribute("title", "Param through path");
        model.addAttribute("text", "Text sent to the route is: " + text);
        return "variables/ver";
    }

    @GetMapping("/string/{text}/{num}")
    public String mixVars(@PathVariable String text, @PathVariable(name="num") Integer number, Model model){
        model.addAttribute("title", "Mix param path");
        model.addAttribute("text", "Mix text sent to the route is: '" + text + "' and with number: " + number);
        return "variables/ver";
    }
}
