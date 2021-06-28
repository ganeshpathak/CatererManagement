package com.management.caterer.service;

import com.management.caterer.dto.CatererRegisterRequestDto;
import com.management.caterer.model.Caterer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public interface CatererService {
     String saveCaterer(CatererRegisterRequestDto caterer);

     List<Caterer> getCaterers();

     Optional<Caterer> getCaterer(long id);

     List<Caterer>  getCaterer(String name);

     List<Caterer>  getCatererByCity(String city);

     String deleteCaterer(long id);
}
