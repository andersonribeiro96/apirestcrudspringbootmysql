package br.com.spring.restspringboot.services;

import br.com.spring.restspringboot.exceptions.ResourceNotFoundException;
import br.com.spring.restspringboot.models.PersonModel;
import br.com.spring.restspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonServices {

    @Autowired
    PersonRepository personrepository;

    public PersonModel create(PersonModel personModel) {
        return personrepository.save(personModel);
    }

    public List<PersonModel> findAll() {
        return personrepository.findAll();
    }

    public PersonModel findById(Long id) {
        return personrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
    }


    public PersonModel update(PersonModel personModel) {
        PersonModel entity = personrepository.findById(personModel.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setFirstName(personModel.getFirstName());
        entity.setLastName(personModel.getLastName());
        entity.setAdress(personModel.getAdress());
        entity.setGender(personModel.getGender());
        return personrepository.save(entity);
    }

    public ResponseEntity<?> delete(Long id) {
        PersonModel entity = personrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        personrepository.delete(entity);
        return ResponseEntity.ok().build();
    }




}
