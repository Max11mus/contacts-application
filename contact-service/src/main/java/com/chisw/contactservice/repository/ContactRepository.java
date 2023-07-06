package com.chisw.contactservice.repository;

import com.chisw.contactservice.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ContactRepository extends CrudRepository<Contact,UUID>{
}
