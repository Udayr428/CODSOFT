package Codsoft_Task3;

import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade() + ", Gender: " + student.getGender() + ", Age: " + student.getAge());
        }
    }

    public void writeToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                // Writing each student's information to the file
                writer.println(student.getName() + "," + student.getRollNumber() + "," +
                        student.getGrade() + "," + student.getGender() + "," + student.getAge());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read student data from a text file
    public void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Splitting the line into fields and creating a new student object
                String[] fields = line.split(",");
                String name = fields[0];
                int rollNumber = Integer.parseInt(fields[1]);
                char grade = fields[2].charAt(0);
                String gender = fields[3];
                int age = Integer.parseInt(fields[4]);

                Student student = new Student(name, rollNumber, grade, gender, age);
                students.add(student);
            }
            System.out.println("Data read from file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

