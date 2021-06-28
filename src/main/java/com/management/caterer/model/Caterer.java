package com.management.caterer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "caterer")
public class Caterer {

    @Transient
    public static final String SEQUENCE_NAME = "id_sequence";

    @Id
    private long id;
    private String name;
    private Location location;
    private Capacity capacity;
    private Contact contact;
}
