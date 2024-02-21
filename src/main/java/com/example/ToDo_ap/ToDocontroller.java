package com.example.ToDo_ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String viewAllToDoitems(Model model, @ModelAttribute("message")String message){
        model.addAttribute("list", todoservice.getAllToDoitems());
        model.addAttribute("message", message);
        return "viewToDoList";/*method best for model view*/
    }
   /* @GetMapping
    public List<ToDoList> getToDo(){
        return  todoservice.getAllToDoitems();
        /this method is used for RESTful API /
    }*/
    @PostMapping("/updateToDoStatus/{id}")
    public  String updateToDOstatus(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (todoservice.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message","update success");
            return  "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","update Failure");
        return "redirect:/viewToDoList";
    }
    @GetMapping("/addToDoItem")
    public String addToDo(Model model){
        model.addAttribute("todoList", new ToDoList());
        return "AddToDoItem";
    }
    @PostMapping("/saveToDoItem")
    public  String saveToDO(ToDoList toDoList,RedirectAttributes redirectAttributes) {
        if(todoservice.saveOrUpdateToDoItem(toDoList)){
            redirectAttributes.addFlashAttribute("message","save successfull");
            return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","save Failed");
        return  "redirect:/addToDOItem";
    }
    @GetMapping("/editToDoitem")
    public String editToDoItem(@PathVariable Long id, Model model){
        model.addAttribute("todoList",todoservice.getAllToDoitems());
        return "EditToDoItem";
    }
    @PostMapping("/editSaveToDoItem")
    public String editToDoItem(ToDoList toDoList,RedirectAttributes redirectAttributes) {
        if(todoservice.saveOrUpdateToDoItem(toDoList)){
            redirectAttributes.addFlashAttribute("message","save successfull");
            return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","save Failed");
        return  "redirect:/addToDOItem";

    }

    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if(todoservice.deleteToDoItems(id)){
            redirectAttributes.addFlashAttribute("message","delete successfull");
        }
        redirectAttributes.addFlashAttribute("message","delete Failed");
        return  ("redirect:/viewToDoList");

    }
}
