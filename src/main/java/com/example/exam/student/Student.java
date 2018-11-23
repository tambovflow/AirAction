package com.example.exam.student;
import com.example.exam.annotation.*;
import com.example.exam.course.Course;
import java.util.*;

public class Student {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Valid(minValue = 0.0f, maxValue = 4.0f)
    private float gpa;

    @NotEmpty
    private List<Course> courses = new ArrayList<>();;

    public Student(){
    	//vor apagayum extends aneluc compile error chta;
    }

    public Student (String firstName, String lastName, float gpa){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.gpa = gpa;
    }
    
    public String getFirstName(){
    	return this.firstName;
    }

    public String getLastName(){
    	return this.lastName;
    }

    public float getGpa(){
    	return this.gpa;
    }

    public void enroll(Course course) {
        courses.add(course);
    }

}