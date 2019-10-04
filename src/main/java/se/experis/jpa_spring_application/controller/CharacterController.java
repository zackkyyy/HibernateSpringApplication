package se.experis.jpa_spring_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import se.experis.jpa_spring_application.model.CharacterCard;
import se.experis.jpa_spring_application.model.CharacterType;
import se.experis.jpa_spring_application.model.User;
import se.experis.jpa_spring_application.repository.CharacterRepository;
import se.experis.jpa_spring_application.repository.ClassRepository;
import se.experis.jpa_spring_application.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */
@RestController
public class CharacterController {
    @Autowired
    private final CharacterRepository characterRepository ;
    private final UserRepository userRepository  ;
    private final ClassRepository classRepository;


    public CharacterController(CharacterRepository characterRepository, UserRepository userRepository, ClassRepository classRepository) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.classRepository = classRepository;
    }

    @GetMapping("/api/characters")
    public List <CharacterCard>  getAllCharacter(){
        List<CharacterCard> allCharacters =  characterRepository.findAll();
        return allCharacters;
    }
    @GetMapping("/api/character/name/{name}")
    public String returnUserByName(@PathVariable String name) {
        List<CharacterCard> allCharacters =characterRepository.findAll();
        CharacterCard characterCard = null;
        for (CharacterCard c:allCharacters) {
            if(c.getCharacterName().equals(name)){
                characterCard = c;
            }
        }
        return characterCard.toString();
    }

    @GetMapping("/api/character/{id}")
    public CharacterCard getByID(@PathVariable int id) {
        CharacterCard characterCard = null;
        List<CharacterCard> allCharacters =characterRepository.findAll();
        for (CharacterCard c:allCharacters) {
            if(c.getId()==id){
                characterCard = c;
            }
        }
        return characterCard;
    }
    @GetMapping("/createCharacter")
    public String addCharacterPostMan(){
        characterRepository.save(new CharacterCard("heroName" , 3, userRepository.findUserByUserName("Zack"), classRepository.findCharacterTypeByName("Warrior")));
        return "added";
    }



    @RequestMapping(method = RequestMethod.POST
            , consumes = {"application/x-www-form-urlencoded"}
            ,value = "/api/character/add"
    )
    public
    @ResponseBody
    CharacterCard addCharacter(@RequestBody MultiValueMap params ){
        System.out.println(params); //name=[Hero], level=[23], Classes=[Fire Fighter], Users=[HNANAS]
        String heroName = params.get("name").toString();
        String level = params.get("level").toString();
        String power = params.get("Classes").toString();
        String userName = params.get("Users").toString();

        heroName =heroName.substring(1,heroName.length()-1);
        level =level.substring(1,level.length()-1);
        power = power.substring(1,power.length()-1);
        userName =userName.substring(1,userName.length()-1);


        return characterRepository.save(new CharacterCard(heroName , Integer.valueOf(level),userRepository.findUserByUserName(userName), classRepository.findCharacterTypeByName(power)));
    }

}
