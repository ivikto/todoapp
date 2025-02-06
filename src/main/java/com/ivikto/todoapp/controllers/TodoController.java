package com.ivikto.todoapp.controllers;

import com.ivikto.todoapp.model.Todoitem;
import com.ivikto.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
        model.addAttribute("newTodo", new Todoitem());

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Todoitem todoitem) {
        todoItemRepository.save(todoitem);

        return "redirect:/";
    }

    @PostMapping("/del/{id}")
    public String del(@ModelAttribute Todoitem todoitem) {
        todoItemRepository.delete(todoitem);

        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchTodoItems(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<Todoitem> allItems = todoItemRepository.findAll();
        List<Todoitem> searchResults = new ArrayList<>();

        for (Todoitem item : allItems) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(item);
            }
        }

        model.addAttribute("allTodos", searchResults);
        model.addAttribute("newTodo", new Todoitem());
        model.addAttribute("searchTerm", searchTerm);

        return "index";



    }


    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new Todoitem("Item 1"));
        todoItemRepository.save(new Todoitem("Item 2"));
        todoItemRepository.save(new Todoitem("Item 3"));

    }
}
