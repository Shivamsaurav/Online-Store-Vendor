package com.api.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.store.payloads.ApiResponse;
import com.api.store.payloads.VendorDto;
import com.api.store.services.VendorService;

@RestController
@RequestMapping("/store/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/")
	public ResponseEntity<VendorDto> addVendor(@RequestBody VendorDto vendorDto){
		
		VendorDto addedVendor = this.vendorService.addVendor(vendorDto);
		return new ResponseEntity<>(addedVendor, HttpStatus.CREATED);
	}
	
	@PutMapping("/{vendorId}")
	public ResponseEntity<VendorDto> updateVendor(@RequestBody VendorDto vendorDto, @PathVariable Integer vendorId){
		
		VendorDto updatedVendor = this.vendorService.updateVendor(vendorDto, vendorId);
		return ResponseEntity.ok(updatedVendor);
	}
	
	@GetMapping("/{vendorId}")
	public ResponseEntity<VendorDto> getVendorDetails(@PathVariable Integer vendorId){
		
		VendorDto vendorDto = this.vendorService.getVendorById(vendorId);
		return ResponseEntity.ok(vendorDto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<VendorDto>> getAllVendorsDetails(){
		
		List<VendorDto> allVendors = this.vendorService.getAllVendors();
		return ResponseEntity.ok(allVendors);
	}
	
	@DeleteMapping("/{vendorId}")
	public ResponseEntity<ApiResponse> deleteVendor(@PathVariable Integer vendorId){
		this.vendorService.deleteVendor(vendorId);
		return new ResponseEntity<>(new ApiResponse("Vendor deleted successfully.", true),HttpStatus.OK);
	}
}
