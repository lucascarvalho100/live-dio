package com.example.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.live.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
