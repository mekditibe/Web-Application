package edu.miu.lab5.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    //street, city and zip.
    @Id
    private Integer Id;
    private String street;
    private String city;
    private String zip;

}
