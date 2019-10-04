package se.experis.jpa_spring_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.jpa_spring_application.model.CharacterType;

public interface ClassRepository extends JpaRepository<CharacterType, Integer> {
    CharacterType findTypeById(int id);
    CharacterType findCharacterTypeByName(String name);
}
