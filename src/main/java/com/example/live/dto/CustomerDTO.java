package com.example.live.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerDTO {

	@NotBlank(message = "O campo 'name' é obrigatório.")
	private String name;

	@NotBlank
	private String cellPhonenumber;

	@NotBlank
	private String addressStreet;

	@NotNull
	@Min(value = 18, message = "Só para maiores de 18 anos.")
	private Integer addressNumber;

	private String addressComplement;

}
