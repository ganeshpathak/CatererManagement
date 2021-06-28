package com.management.caterer.service;

import com.management.caterer.advice.TrackExecutionTime;
import com.management.caterer.dto.CatererRegisterRequestDto;
import com.management.caterer.model.Capacity;
import com.management.caterer.model.Caterer;
import com.management.caterer.model.Contact;
import com.management.caterer.model.Location;
import com.management.caterer.repository.CatererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatererServiceImpl implements CatererService {

    @Autowired
    CatererRepository catererRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public String saveCaterer(CatererRegisterRequestDto caterer) {
        catererRepository.save(mapCatererRegisterRequestDtoToCaterer(caterer));
        return "Added Successfully ";
    }

    @Override
    @TrackExecutionTime
    public List<Caterer> getCaterers() {
        return catererRepository.findAll();
    }

    @Override
    @TrackExecutionTime
    public Optional<Caterer> getCaterer(long id) {
            return catererRepository.findById(id);
    }

    @Override
    @TrackExecutionTime
    public List<Caterer> getCaterer(String name) {
        return catererRepository.findByName(name);
    }

    @Override
    @TrackExecutionTime
    public List<Caterer> getCatererByCity(String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("location.city").is(city));

        return mongoTemplate.find(query, Caterer.class);
    }

    @Override
    public String deleteCaterer(long id) {
       catererRepository.deleteById(id);
       return "Caterer deleted with ID : " + id;
    }

    private Caterer mapCatererRegisterRequestDtoToCaterer(CatererRegisterRequestDto dto) {

        Contact contact = Contact.builder().email(dto.getEmail()).phoneNumber(dto.getPhoneNumber())
                .mobile(dto.getMobile()).build();
        Location location = Location.builder().city(dto.getCity()).street(dto.getStreet())
                .postalCode(dto.getPostalCode()).build();
        Capacity capacity = Capacity.builder().minGuest(dto.getMinGuest()).maxGuest(dto.getMaxGuest()).build();
        return Caterer.builder().id(sequenceGeneratorService.generateSequence(Caterer.SEQUENCE_NAME)).name(dto.getName()).capacity(capacity).location(location).contact(contact).build();
    }
}
