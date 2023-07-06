package com.chisw.contactservice.entities;

import com.chisw.contactservice.validation.PhoneNumberValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;


@Entity
@Table(name = "phone_number")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue
    @Column(name = "phone_id", updatable = false)
    private UUID id;

    @Column(name = "phone")
    @NotBlank(message = "PhoneNumber is required")
    @PhoneNumberValid
    @Size(max = 100, message = "PhoneNumber must be at most 100 characters")
    private String phone;

}
