package com.api.store.services;

import com.api.store.payloads.VendorDto;
import java.util.List;

public interface VendorService {

  VendorDto addVendor(VendorDto vendorDto);

  VendorDto updateVendor(VendorDto vendorDto, Integer vendorId);

  VendorDto getVendorById(Integer vendorId);

  List<VendorDto> getAllVendors();

  void deleteVendor(Integer vendorId);
}
