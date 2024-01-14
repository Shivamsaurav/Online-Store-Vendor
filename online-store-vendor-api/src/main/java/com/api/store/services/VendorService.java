package com.api.store.services;

import java.util.List;

import com.api.store.payloads.VendorDto;

public interface VendorService {

	VendorDto addVendor(VendorDto vendorDto);
	
	VendorDto updateVendor(VendorDto vendorDto, Integer vendorId);
	
	VendorDto getVendorById(Integer vendorId);
	
	List<VendorDto> getAllVendors();
	
	void deleteVendor(Integer vendorId);
}
