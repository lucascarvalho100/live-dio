package com.example.live.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerDetailDTO {

	private long id;

	private String name;

	private String cellPhonenumber;

	private AddressDTO address;

	private Timestamp createAt;

	private Timestamp updateAt;
	

}
