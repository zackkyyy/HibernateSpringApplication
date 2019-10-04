package se.experis.jpa_spring_application.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.jpa_spring_application.model.CharacterType;
import se.experis.jpa_spring_application.model.User;

import java.util.List;


/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);
    User  save(User user);
    List<User> findAll();
    User findUserByUserName(String userName);
}
