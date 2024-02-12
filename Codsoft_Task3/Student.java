package Codsoft_Task3;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private char grade;
    private String gender;
    private int age;

    public Student(String name, int rollNumber, char grade, String gender, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

