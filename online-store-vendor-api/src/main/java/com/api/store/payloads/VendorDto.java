package com.api.store.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class VendorDto {

  private Integer vendorId;
  private String vendorName;
  private String vendorAddress;
  private String vendorcontact;
}
