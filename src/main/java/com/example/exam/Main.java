package com.example.exam;
import com.example.exam.student.Student;
import com.example.exam.course.Course;
import com.example.exam.validator.Validator;

public class Main {

    public static void main(String... args) {
        Course c1 = new Course("Databases", "CS101");
        Course c2 = new Course("Introduction to programming", "CS102");

        Student student = new Student("John", "Smith", 3.5f);
        Student student1 = new Student();
       	student.enroll(c1);
        student.enroll(c2);

        Validator validator = new Validator();
        if(!validator.isValid(student)) {
            throw new IllegalArgumentException();
        }
    }
}
