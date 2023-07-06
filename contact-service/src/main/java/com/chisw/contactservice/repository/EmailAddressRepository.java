package com.chisw.contactservice.repository;

import com.chisw.contactservice.entities.EmailAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmailAddressRepository extends CrudRepository<EmailAddress, UUID> {
}
