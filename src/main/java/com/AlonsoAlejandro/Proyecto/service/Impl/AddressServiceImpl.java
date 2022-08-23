package com.AlonsoAlejandro.Proyecto.service.Impl;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Address;
import com.AlonsoAlejandro.Proyecto.persistence.repository.IAddressRepository;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final IAddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Optional<Address> search(Integer id) {
        return addressRepository.findById(Long.valueOf(id));
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address modify(Address address) {
        return addressRepository.save(address);
    }
}
