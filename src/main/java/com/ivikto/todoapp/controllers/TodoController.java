package com.ivikto.todoapp.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class TodoController {

    public String index() {
        return "index";
    }
}
