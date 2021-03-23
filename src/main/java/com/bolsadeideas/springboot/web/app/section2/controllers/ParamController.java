package com.bolsadeideas.springboot.web.app.section2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/param")
public class ParamController {

    @GetMapping({"/", "/index", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Index Params Page");
        return "param/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "text", required = false) String text, Model model) {
        model.addAttribute("title", "String params");
        model.addAttribute("text", "Text sent for params: '" + text + "'");
        return "param/ver";
    }

    @GetMapping("/mix_type")
    public String param(@RequestParam String text, @RequestParam Integer number, Model model) {
        model.addAttribute("title", "Mix param");
        model.addAttribute("text", "Text sent for params: '" + text + "', y el numero: " + number);
        return "param/ver";
    }

    @GetMapping("/mix_type_req")
    public String param(HttpServletRequest req, Model model) {
        String text = req.getParameter("text");
        Integer num = null;
        try {
            num = Integer.parseInt(req.getParameter("number"));
        } catch (NumberFormatException e) {
            num = 0;
            System.out.print(e);
        }
        model.addAttribute("text", "Texto enviado por parametro: '" + text + "', y el numero: " + num);
        model.addAttribute("title", "Request param");
        return "param/ver";
    }

}
