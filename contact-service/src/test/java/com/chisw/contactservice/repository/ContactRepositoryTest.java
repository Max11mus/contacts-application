package com.chisw.contactservice.repository;

import com.chisw.contactservice.entities.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "/test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(value = "/clear_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @Test
    @Sql(value = "/insert_all_data.sql")
    void findById_MustFindExistedContact() {
        //given
        UUID expectedContactId = UUID.fromString("a6e4197c-b4f7-4fec-bf49-ca3a89d63676");

        //when
        Contact actualContact = contactRepository.findById(expectedContactId).get();

        //then
        assertNotNull(actualContact);
        assertEquals(expectedContactId, actualContact.getId());
    }

    @Test
    @Sql(value = "/insert_all_data.sql")
    void findAll_MustFindAllContacts() {
        //given
        String[] expectedContactUuids = {"a6e4197c-b4f7-4fec-bf49-ca3a89d63676", "15409cf2-c887-4c37-ab4e-79e11a6f6833"};
        List<UUID> listExpectedTeacherUuids = Arrays.asList(expectedContactUuids)
                .stream()
                .map(s -> UUID.fromString(s))
                .collect(Collectors.toList());
        Collections.sort(listExpectedTeacherUuids);

        //when
        List<UUID> actualContactUuids = new ArrayList<>();
        Iterable<Contact> all = contactRepository.findAll();
        all.forEach(s -> actualContactUuids.add(s.getId()));
        Collections.sort(actualContactUuids);

        //then
        assertEquals(listExpectedTeacherUuids, actualContactUuids);
    }

    @Test
    void save_MustCreateNewContact() {
        //given
        Contact expectedContact = new Contact();

        //when
        contactRepository.save(expectedContact);
        Contact actualContact = contactRepository.findById(expectedContact.getId()).get();

        //then
        assertNotNull(actualContact);
        assertEquals(expectedContact, actualContact);
    }

    @Test
    @Sql(value = "/insert_all_data.sql")
    void save_MustUpdateExistedContact() {
        //given
        UUID expectedContactUuid = UUID.fromString("15409cf2-c887-4c37-ab4e-79e11a6f6833");
        String expectedContactName = "Ronald Reagan";
        Contact expectedContact = contactRepository.findById(expectedContactUuid).get();
        expectedContact.setName(expectedContactName);

        //when
        contactRepository.save(expectedContact);
        Contact actualContact = contactRepository.findById(expectedContact.getId()).get();

        //then
        assertNotNull(actualContact);
        assertEquals(expectedContact, actualContact);
    }

    @Test
    @Sql(value = "/insert_all_data.sql")
    void deleteById_MustDeleteExistedContact() {
        //given
        UUID expectedContactUuid = UUID.fromString("a6e4197c-b4f7-4fec-bf49-ca3a89d63676");
        Contact expectedContactBeforeDelete = contactRepository.findById(expectedContactUuid).get();
        Contact expectedContactAfterDelete = null;

        //when
        contactRepository.deleteById(expectedContactUuid);
        Contact actualContact = contactRepository.findById(expectedContactUuid).orElse(null);

        //then
        assertNotNull(expectedContactBeforeDelete);
        assertEquals(expectedContactUuid, expectedContactBeforeDelete.getId());

        assertNull(expectedContactAfterDelete);
        assertEquals(expectedContactAfterDelete, actualContact);
    }

}