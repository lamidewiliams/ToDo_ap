package com.example.ToDo_ap;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import  java.util.Date;
@Entity
@Table (name="ToDoList")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String titles;
    private Date date;
    private String status;

    public ToDoList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
