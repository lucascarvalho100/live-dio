package com.example.live.configuration;

import java.util.Optional;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.live.dto.AddressDetailDTO;
import com.example.live.model.Address;

@Configuration
public class ModelMapperConfiguration {

	private Converter<Address, AddressDetailDTO> addressToAddressDetailDTO = new AbstractConverter<Address, AddressDetailDTO>() {

		@Override
		protected AddressDetailDTO convert(Address source) {

			if (source == null)
				return null;

			return new AddressDetailDTO(String.format("%s - %s %s", source.getStreet(), source.getNumber(),
					Optional.ofNullable(source.getComplement()).orElse("")));
		}
	};

	@Bean
	public ModelMapper inject() {

		var modelMapper = new ModelMapper();
		modelMapper.addConverter(addressToAddressDetailDTO);

		return modelMapper;
	}

}
