package com.example.live.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AddressDTO {

	private long id;

	private String street;

	private int number;

	private String complement;

	private Timestamp createAt;

	private Timestamp updateAt;

}
