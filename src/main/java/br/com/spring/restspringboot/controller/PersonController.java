package br.com.spring.restspringboot.controller;


import br.com.spring.restspringboot.models.PersonModel;
import br.com.spring.restspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices services;


    @GetMapping
    public List<PersonModel> findByAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public PersonModel findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping
    public PersonModel create(@RequestBody PersonModel personModel) {
        return services.create(personModel);
    }

    @PutMapping
    public PersonModel update(@RequestBody PersonModel personModel) {
        return services.update(personModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }


}
