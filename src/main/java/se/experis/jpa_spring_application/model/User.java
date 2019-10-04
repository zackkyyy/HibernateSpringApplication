package se.experis.jpa_spring_application.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */
@Entity
@Table
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;

    @Column(name="UserName")
    public String  userName;

    @Column(name="Password")
    public String password;


    @OneToMany()
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("characterCards")
    public List<CharacterCard> characterCards ;



    public User() {
    }

    public User(String userName , String password) {
        id=0;
        this.password =password;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CharacterCard> getCharacterCard() {
        return characterCards;
    }

    public void setCharacterCard(List<CharacterCard> characterCard) {
        this.characterCards = characterCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
