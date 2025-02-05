package com.ivikto.todoapp.controllers;

import com.ivikto.todoapp.model.Todoitem;
import com.ivikto.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController implements CommandLineRunner {

    public TodoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    private final TodoItemRepository todoItemRepository;

    @GetMapping
    public String index(Model model) {

        List<Todoitem> allTodos = todoItemRepository.findAll();
        model.addAttribute("allTodos", allTodos);

        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new Todoitem("Item 1"));
        todoItemRepository.save(new Todoitem("Item 2"));
        todoItemRepository.save(new Todoitem("Item 3"));

    }
}
