package vn.edu.ptit.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.ptit.toiec.data.entities.Flashcard;
import vn.edu.ptit.toiec.data.repository.FlashCardRepository;
import vn.edu.ptit.toiec.usecases.FlashCardService;

import java.util.List;
@Service
@Transactional
public class FlashCardServiceImpl implements FlashCardService {
    @Autowired
    private FlashCardRepository flashCardRepository;
    @Override
    public List<Flashcard> getAll() {
        return flashCardRepository.findAll();
    }

    @Override
    public void create(Flashcard flashcard) {
        flashCardRepository.save(flashcard);
    }

    @Override
    public void update(Flashcard flashcard, Integer id) {
        Flashcard flashcardOld = flashCardRepository.findById(id).get();
        flashcardOld.setContent(flashcard.getContent());
        flashcardOld.setWord(flashcard.getWord());
        flashcardOld.setImage(flashcard.getImage());
        flashcardOld.setNouns(flashcard.getNouns());
        flashcardOld.setTypeword(flashcard.getTypeword());
        flashCardRepository.save(flashcardOld);
    }

    @Override
    public void delete(Integer id) {
        flashCardRepository.deleteById(id);
    }
}
