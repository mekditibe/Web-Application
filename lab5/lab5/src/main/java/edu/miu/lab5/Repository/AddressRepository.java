package edu.miu.lab5.Repository;

import edu.miu.lab5.Entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepository extends MongoRepository<Address, Integer> {

    List<Address> findAddressByCity(String city);
}
