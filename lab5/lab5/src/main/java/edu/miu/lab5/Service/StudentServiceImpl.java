package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Address;
import edu.miu.lab5.Entity.Student;
import edu.miu.lab5.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void add5Student(){
        Address address= new Address(1,"striet","city","zip");
        Address address2= new Address(2,"striet2","city2","zip2");
        addStudent(new Student(1,"tttn", "48777563","maop@gm.com",address));
        addStudent(new Student(2,"Mekdes", "1234563","makd@gm.com",address2));
        addStudent(new Student(3,"Noo", "24421","op@gm.com",address));
        addStudent(new Student(4,"Sun", "98609","jh@gm.com",address2));
        addStudent(new Student(5,"Gim", "57093","op@gm.com",address2));
    }

    @Override
    public Student findStudentById(Integer Id) {
        return studentRepository.findStudentById(Id);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public Student finsStudentByPhoneNumber(String phoneNumber) {
        return studentRepository.findStudentByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> findStudentByCity(String city) {
        return studentRepository.findStudentByAddress_City(city);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
