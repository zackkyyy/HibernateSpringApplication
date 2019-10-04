package se.experis.jpa_spring_application.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

/**
 * Author : Zacky Kharboutli
 * Date : 2019-10-02
 * Project: JPASpringApplication
 */

@Entity
@Table
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="CharacterType")
public class CharacterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;


    @Column
    public String name;

    @OneToMany()
    @JoinColumn(name = "class_id")
    @JsonIgnoreProperties("characterCards")
    public List<CharacterCard> characterCards ;



    public CharacterType() {
        this.id=0;
    }

    public CharacterType(String type) {
        this.name=type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CharacterCard> getCharacterCards() {
        return characterCards;
    }

    public void setCharacterCards(List<CharacterCard> characterCards) {
        this.characterCards = characterCards;
    }

    @Override
    public String toString() {
        return "CharacterType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
