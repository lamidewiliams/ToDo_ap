package com.example.ToDo_ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  ToDoService {
    @Autowired
     ToDorepo repo;
    List<ToDoList> getAllToDoitems(){
        ArrayList<ToDoList>  todo = new ArrayList<>();
        repo.findAll().forEach(toDoList -> todo.add(toDoList));
        return  todo;

    }
    ToDoList getTODOitemBYId(Long id){
        return repo.findById(id).get();

    }
    boolean updateStatus(Long id){
        ToDoList toDoList = getTODOitemBYId(id);
        toDoList.setStatus("complete");
        return  saveOrUpdateToDoItem(toDoList);
    }
    boolean saveOrUpdateToDoItem(ToDoList toDoList){
    ToDoList updateobj = repo.save(toDoList );
    if (getTODOitemBYId(updateobj.getId()) != null){
        return true;
    }
    return  false;
    }
    public boolean deleteToDoItems(Long id){
        repo.deleteById(id);

        if (getTODOitemBYId(id) == null) {
            return true;
        }return false;
    }


}
