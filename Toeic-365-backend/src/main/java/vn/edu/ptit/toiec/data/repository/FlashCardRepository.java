package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.ptit.toiec.data.entities.Flashcard;

public interface FlashCardRepository extends JpaRepository<Flashcard,Integer> {
}
