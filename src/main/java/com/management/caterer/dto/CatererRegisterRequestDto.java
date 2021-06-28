package com.management.caterer.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class CatererRegisterRequestDto {

    @Id
    private long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String street;
    private String postalCode;


    @NotNull
    @Positive
    private int minGuest;

    @NotNull
    @Positive
    private int maxGuest;

    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String mobile;

    @NotNull
    @NotEmpty
    @Email
    private String email;
}
