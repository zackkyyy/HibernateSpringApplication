package se.experis.jpa_spring_application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */
@Entity
public class CharacterCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "CharacterName")
    public String characterName ;

    @Column(name = "Level")
    public int level ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
  //  @JoinColumn(name = "UserName", referencedColumnName = "username", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "class_id")
    private CharacterType characterType;



    public CharacterCard(String heroName, Integer valueOf, CharacterType characterType) {
        this.id=0;
        this.characterName = heroName;
        this.level=valueOf;
        this.characterType= characterType;
    }

    public CharacterCard() {
        this.id=0;

    }

    public CharacterCard(String heroName, Integer valueOf, User user, CharacterType characterType) {
        this.id=0;
        this.characterName = heroName;
        this.level=valueOf;
        this.user=user;
        this.characterType= characterType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public String toString() {
        return "CharacterCard{" +
                ", characterName='" + characterName + '\'' +
                ", level=" + level +
                ", user=" + user +
                ", characterType=" + characterType +
                '}';
    }
}
