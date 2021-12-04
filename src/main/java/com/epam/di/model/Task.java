package com.epam.di.model;


import java.util.List;

public class Task {
    private String title;
    private List<User> users;

    public void  myInit(){
        System.out.println("Task bean  initalized");
    }
    public void  myDestroy(){
        System.out.println("Task bean " +
                " destroyed");
    }

    public Task() {
    }

    public Task(String title, List<User> users) {
        this.title = title;
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", users=" + users +
                '}';
    }
}
