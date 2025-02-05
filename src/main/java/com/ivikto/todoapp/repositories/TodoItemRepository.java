package com.ivikto.todoapp.repositories;

import com.ivikto.todoapp.model.Todoitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<Todoitem, Long> {
}
