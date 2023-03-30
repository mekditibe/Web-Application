package edu.miu.lab5.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    //s name, phoneNumber and email.
    @Id
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private Address address;
}
