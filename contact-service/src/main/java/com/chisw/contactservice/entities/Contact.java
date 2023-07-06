package com.chisw.contactservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "contact_id", updatable = false)
    private UUID id;


    @Column(name = "owner_id")
    @NotBlank(message = "Owner_id is required")
    private UUID ownerId;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Column(name = "contact_name", nullable = false, unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "contact_id")
    private Set<PhoneNumber> phoneNumbers;

    @OneToMany
    @JoinColumn(name = "contact_id")
    private Set<EmailAddress> emailAddresses;

}
