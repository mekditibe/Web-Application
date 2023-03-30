package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    Student findStudentById(Integer Id);
    Student findStudentByName(String name);
    Student finsStudentByPhoneNumber(String phoneNumber);
    List<Student> findStudentByCity(String city);
    List<Student> getAllStudent();

}
