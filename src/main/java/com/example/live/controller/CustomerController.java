package com.example.live.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.live.dto.AddressDetailDTO;
import com.example.live.dto.CustomerDTO;
import com.example.live.dto.CustomerDetailDTO;
import com.example.live.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping
	public ResponseEntity<CustomerDetailDTO> insert(@RequestBody @Valid CustomerDTO customer) {
		return ResponseEntity.ok(service.save(customer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDetailDTO> findById(@PathVariable long id) {
		
		var customer = service.findById(id);

		if (customer.isPresent())
			return ResponseEntity.ok(customer.get());

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDetailDTO> update(@PathVariable long id, @RequestBody @Valid CustomerDTO customer) {
		return ResponseEntity.ok(service.update(id, customer));
	}

	@GetMapping("/{id}/address")
	public ResponseEntity<AddressDetailDTO> findAddressByCustomerId(@PathVariable long id) {

		var address = service.findAddressByCustomerId(id);

		if (address.isPresent())
			return ResponseEntity.ok(address.get());

		return ResponseEntity.notFound().build();
	}
}
