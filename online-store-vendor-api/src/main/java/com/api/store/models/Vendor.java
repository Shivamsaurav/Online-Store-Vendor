package com.api.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendor_information")
@Data
@NoArgsConstructor
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer vendorId;

  @Column(name = "VENDOR_NAME")
  private String vendorName;

  @Column(name = "ADDRESS")
  private String vendorAddress;

  @Column(name = "CONTACT")
  private String vendorcontact;
}
