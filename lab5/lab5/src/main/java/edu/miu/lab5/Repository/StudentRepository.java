package edu.miu.lab5.Repository;

import edu.miu.lab5.Entity.Address;
import edu.miu.lab5.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    List<Student> findStudentByAddress_City(String city);
    Student findStudentById(Integer Id);
    List<Student> findAll();
    Student findStudentByName(String name);
    Student findStudentByPhoneNumber(String phoneNumber);


}
