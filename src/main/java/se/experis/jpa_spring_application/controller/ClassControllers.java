package se.experis.jpa_spring_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.jpa_spring_application.model.CharacterType;
import se.experis.jpa_spring_application.repository.ClassRepository;

import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */

@RestController
public class ClassControllers {

    final private ClassRepository classRepository;

    public ClassControllers(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @GetMapping("/api/classes")
    public List<CharacterType> getAllClasses(){
        return classRepository.findAll();
    }

    @GetMapping("/api/class/{className}")
    public CharacterType getClassByName(@PathVariable String className){
        return classRepository.findCharacterTypeByName(className);
    }

    @GetMapping("/types/add/{type}")
    public String addTypes(@PathVariable String type ){
        CharacterType characterType =new CharacterType(type);
        classRepository.save(characterType);
        return "Type added";
    }
}
