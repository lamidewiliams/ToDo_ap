package com.example.ToDo_ap;

import com.example.ToDo_ap.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDorepo extends JpaRepository<ToDoList, Long> {
}
