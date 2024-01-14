package com.api.store.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.store.exceptions.ResourceNotFoundException;
import com.api.store.models.Vendor;
import com.api.store.payloads.VendorDto;
import com.api.store.repositories.VendorRepo;
import com.api.store.services.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private VendorRepo vendorRepo;
	
	@Override
	public VendorDto addVendor(VendorDto vendorDto) {
		
		Vendor vendor = this.vendorDtoToVendor(vendorDto);
		Vendor createdVendor = this.vendorRepo.save(vendor);		
		return this.vendorToVendorDto(createdVendor);
	}

	@Override
	public VendorDto updateVendor(VendorDto vendorDto, Integer vendorId) {
		
		Vendor vendor = this.vendorRepo.findById(vendorId).
				orElseThrow(()-> new ResourceNotFoundException("Vendor", "Id", vendorId));
		
		vendor.setVendorName(vendorDto.getVendorName());
		vendor.setVendorAddress(vendorDto.getVendorAddress());
		vendor.setVendorcontact(vendorDto.getVendorcontact());
		
		Vendor updatedVendor = this.vendorRepo.save(vendor);
		
		return this.vendorToVendorDto(updatedVendor);
	}

	@Override
	public VendorDto getVendorById(Integer vendorId) {
		
		Vendor vendor = this.vendorRepo.findById(vendorId).
				orElseThrow(()->new ResourceNotFoundException("Vendor", "Id", vendorId));
		
		return this.vendorToVendorDto(vendor);
	}

	@Override
	public List<VendorDto> getAllVendors() {
		
		List<Vendor> allVendors = this.vendorRepo.findAll();
		
		List<VendorDto> allVendorsDto = allVendors.stream().map(vendor -> this.vendorToVendorDto(vendor)).collect(Collectors.toList());
		
		return allVendorsDto;
	}

	@Override
	public void deleteVendor(Integer vendorId) {
		
		Vendor vendor = this.vendorRepo.findById(vendorId).
				orElseThrow(()->new ResourceNotFoundException("Vendor", "Id", vendorId));
		
		this.vendorRepo.delete(vendor);

	}
	
	public VendorDto vendorToVendorDto(Vendor vendor) {
		
		VendorDto vendorDto = this.modelMapper.map(vendor, VendorDto.class);
		return vendorDto;
	}

	public Vendor vendorDtoToVendor(VendorDto vendorDto) {
		
		Vendor vendor = this.modelMapper.map(vendorDto, Vendor.class);
		return vendor;
	}
}
