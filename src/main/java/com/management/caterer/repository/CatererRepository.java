package com.management.caterer.repository;

import com.management.caterer.model.Caterer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CatererRepository extends MongoRepository<Caterer, Long> {

    @Query("{name: ?0}")
    List<Caterer> findByName(String name);

}
