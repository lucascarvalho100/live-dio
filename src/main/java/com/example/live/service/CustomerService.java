package com.example.live.service;

import java.util.Optional;

import com.example.live.dto.AddressDetailDTO;
import com.example.live.dto.CustomerDTO;
import com.example.live.dto.CustomerDetailDTO;

public interface CustomerService {

	CustomerDetailDTO save(CustomerDTO customerDTO);

	CustomerDetailDTO update(long id, CustomerDTO customerDTO);

	Optional<CustomerDetailDTO> findById(long id);

	Optional<AddressDetailDTO> findAddressByCustomerId(long id);

}
