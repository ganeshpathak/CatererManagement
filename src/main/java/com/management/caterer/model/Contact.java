package com.management.caterer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Contact {
    private String phoneNumber;
    private String mobile;
    private String email;
}
