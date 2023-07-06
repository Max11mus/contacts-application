package com.chisw.contactservice.repository;

import com.chisw.contactservice.entities.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, UUID> {
}
