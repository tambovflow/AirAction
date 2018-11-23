package com.example.exam.course;

public class Course {

    private String name;
    private String code;

    public Course(String name, String code){
    	this.name = name;
    	this.code = code;
    }
    
    public String getName(){
    	return this.name;
    }

    public String getCode(){
    	return this.code;
    }
}