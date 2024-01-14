package com.api.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.store.models.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {

}
