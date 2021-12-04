package com.epam.di.model;

public class User {
    private String name;
    private  int age;
    private boolean active;

    public void  myInit(){
        System.out.println("User bean  initalized");
    }
    public void  myDestroy(){
        System.out.println("User bean  destroyed");
    }


    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;

    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
