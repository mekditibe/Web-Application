package edu.miu.lab5.Controller;

import edu.miu.lab5.Entity.Student;
import edu.miu.lab5.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping()
    public List<Student> getStudents(){
        studentService.add5Student();
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        studentService.add5Student();
        return studentService.findStudentById(id);
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public Student getStudentByPhoneNumber(@PathVariable String phoneNumber){
        return studentService.finsStudentByPhoneNumber(phoneNumber);
    }
    @GetMapping("/city/{city}")
    public List<Student> getStudentByCity(@PathVariable String city){
        return studentService.findStudentByCity(city);
    }

}
