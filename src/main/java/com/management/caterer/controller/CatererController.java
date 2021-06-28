package com.management.caterer.controller;

import com.management.caterer.dto.CatererRegisterRequestDto;
import com.management.caterer.model.Caterer;
import com.management.caterer.service.CatererService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CatererController {

    @Autowired
    CatererService catererService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/addCaterer")
    public String saveCaterer(@Valid @RequestBody CatererRegisterRequestDto catererDto) {
        log.info("Request body for add request : {}", catererDto);
        String res =  catererService.saveCaterer(catererDto);
        log.info("Response : {}", res);

        return res;
    }

    @GetMapping("/findAllCaterer")
    public List<Caterer> getCaterers() {
        return catererService.getCaterers();
    }

    @GetMapping("/findAllCaterer/{id}")
    @Cacheable(key = "#id",value = "Caterer")
    public Optional<Caterer> getCaterer(@PathVariable long id) {
        return catererService.getCaterer(id);
    }

    @GetMapping("/findAllCaterer/name/{name}")
    public List<Caterer> getCaterer(@PathVariable String name) {
        return catererService.getCaterer(name);
    }

    @GetMapping("/findAllCaterer/city/{city}")
    public List<Caterer> getCatererByCity(@PathVariable String city) {
        return catererService.getCatererByCity(city);
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(key = "#id",value = "Caterer")
    public String deleteCaterer(@PathVariable long id) {
        return catererService.deleteCaterer(id);
    }
}
