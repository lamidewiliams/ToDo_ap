package com.example.ToDo_ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDocontroller {
    @Autowired
    private final ToDoService todoservice;
    @Autowired
    public  ToDocontroller( final ToDoService todoservice){
        this.todoservice= todoservice;
    }
    @GetMapping({"/", "viewToDoList"})
    public String viewAllToDoitems(Model model){
        model.addAttribute("list", todoservice.getAllToDoitems());
        return "viewToDoList";/*method best for model view*/
    }
   /* @GetMapping
    public List<ToDoList> getToDo(){
        return  todoservice.getAllToDoitems();
        /this method is used for RESTful API /
    }*/
    @PostMapping("/updateToDoStatus/{id}")
    public  String updateToDOstatus(@PathVariable Long id){
        if (todoservice.updateStatus(id)) {
            return  "redirect:/viewToDoList";
        }
        return "";
    }
    @GetMapping
    public String addToDo(){

    }
    @PostMapping
    public  String saveToDO() {

    }
    @GetMapping
    public String editToDo(){

    }
    @GetMapping
    public String editToDoItem(){

    }
    @PostMapping
    public String editsaveToDOItem(){

    }
    @GetMapping
    public String deleteToDoItem(){

    }
}
