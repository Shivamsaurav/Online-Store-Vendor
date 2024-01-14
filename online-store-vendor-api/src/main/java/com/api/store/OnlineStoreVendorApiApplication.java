package com.api.store;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineStoreVendorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreVendorApiApplication.class, args);
	}
    
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
