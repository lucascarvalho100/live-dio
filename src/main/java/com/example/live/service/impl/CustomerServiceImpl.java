package com.example.live.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.live.dto.AddressDetailDTO;
import com.example.live.dto.CustomerDTO;
import com.example.live.dto.CustomerDetailDTO;
import com.example.live.model.Customer;
import com.example.live.repository.CustomerRepository;
import com.example.live.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}

	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;

	@Override
	public CustomerDetailDTO save(CustomerDTO customerDTO) {
		var customer = this.modelMapper.map(customerDTO, Customer.class);
		var customerSaved = this.customerRepository.save(customer);
		return this.modelMapper.map(customerSaved, CustomerDetailDTO.class);
	}

	@Override
	public Optional<CustomerDetailDTO> findById(long id) {

		var customer = this.customerRepository.findById(id);

		if (customer.isPresent())
			return Optional.of(this.modelMapper.map(customer.get(), CustomerDetailDTO.class));

		return Optional.empty();
	}

	@Override
	public Optional<AddressDetailDTO> findAddressByCustomerId(long id) {
		var customer = this.customerRepository.findById(id);

		if (customer.isPresent())
			return Optional.of(this.modelMapper.map(customer.get().getAddress(), AddressDetailDTO.class));

		return Optional.empty();
	}

	@Override
	public CustomerDetailDTO update(long id, CustomerDTO customerDTO) {

		var currentCustomer = this.customerRepository.findById(id);

		if (!currentCustomer.isPresent())
			return null; // Correto seria fazer um exception...

		var customerToBeSaved = this.modelMapper.map(customerDTO, Customer.class);
		
		BeanUtils.copyProperties(customerToBeSaved, currentCustomer.get(), "id", "createAt", "address");
		BeanUtils.copyProperties(customerToBeSaved.getAddress(), currentCustomer.get().getAddress(), "id", "createAt");

		return this.modelMapper.map(this.customerRepository.save(currentCustomer.get()), CustomerDetailDTO.class);
	}

}
