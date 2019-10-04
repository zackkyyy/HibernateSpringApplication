package se.experis.jpa_spring_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.experis.jpa_spring_application.model.CharacterCard;
import se.experis.jpa_spring_application.model.CharacterType;
import se.experis.jpa_spring_application.model.User;
import se.experis.jpa_spring_application.repository.CharacterRepository;
import se.experis.jpa_spring_application.repository.ClassRepository;
import se.experis.jpa_spring_application.repository.UserRepository;

import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */
@Controller
public class APIsController {
    private final CharacterRepository characterRepository ;
    private final ClassRepository classRepository;
    private final UserRepository userRepository;

    public APIsController(CharacterRepository characterRepository, ClassRepository classRepository, UserRepository userRepository) {
        this.characterRepository = characterRepository;
        this.classRepository = classRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/api/addCharacter")
    public String goToAddCharacter(Model model){
        List<CharacterType> allCharacterClasses = classRepository.findAll();
        List<User> allUsers = userRepository.findAll();
        model.addAttribute("Classes" , allCharacterClasses);
        model.addAttribute("Users", allUsers);
        return "addCharacter";
    }

    @GetMapping("/api/addUser")
    public String goToAddUser(Model model){
        List<CharacterCard> allCharacters = characterRepository.findAll();
      //  List<CharacterType> allClasses = classRepository.findAll();
        model.addAttribute("Characters" , allCharacters);
        //model.addAttribute("Classes",allClasses);

        return "addUser";
    }
}
