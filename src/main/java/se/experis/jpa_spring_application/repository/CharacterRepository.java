package se.experis.jpa_spring_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.experis.jpa_spring_application.model.CharacterCard;

import javax.persistence.TypedQuery;
import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterCard, Integer> {
    CharacterCard save(CharacterCard chara);
    List<CharacterCard> findAll();
     CharacterCard findCharacterCardById(int id);
     CharacterCard findCharacterCardByCharacterName(String name);
}

