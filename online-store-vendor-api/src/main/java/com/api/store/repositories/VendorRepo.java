package com.api.store.repositories;

import com.api.store.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {}
