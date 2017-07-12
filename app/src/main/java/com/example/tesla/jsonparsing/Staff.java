package com.example.tesla.jsonparsing;

/**
 * Created by Tesla on 7/11/2017.
 */

public class Staff {
    private String name;
    private int age;
    private String position;
    private int salary;

    public String getName(){
        return name;
    }
    public void setName(String input){
        this.name = input;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int input){
        this.age = input;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String input){
        this.position = input;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int input){
        this.salary = input;
    }
}
