package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Address;


public interface AddressService {
    void addAddress(Address address);
    Address findAddressById(Integer Id);
}
