package se.experis.jpa_spring_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import se.experis.jpa_spring_application.model.User;
import se.experis.jpa_spring_application.repository.UserRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */

@RestController
public class UserController {
    List<User> listOfUsers;
    @Autowired
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.POST
            , consumes = {"application/x-www-form-urlencoded"}
            ,value = "/api/user/add"
    )
    public
     String addAUser(@RequestBody MultiValueMap params){
        String name = params.get("name").toString();
        String password = params.get("password").toString();
        name =name.substring(1,name.length()-1);
        password =password.substring(1,password.length()-1);
        userRepository.save(new User(name,password));
        return "200";
    }



    @GetMapping("/api/users")
    public List<User> getALLUsers(){
        listOfUsers =userRepository.findAll();
        return listOfUsers;
    }
    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable int id){
        return userRepository.findUserById(id);
    }

    public List<User> getUserList(){
        listOfUsers =userRepository.findAll();
        return listOfUsers;
    }
}
