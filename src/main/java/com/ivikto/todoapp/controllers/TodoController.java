package com.ivikto.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TodoController {

    public String index(Model model) {
        model.addAttribute("data", "Hello");
        return "index";
    }
}
