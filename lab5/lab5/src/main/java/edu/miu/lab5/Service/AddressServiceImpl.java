package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Address;
import edu.miu.lab5.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Integer Id) {
        return addressRepository.findById(Id).get();
    }
}
