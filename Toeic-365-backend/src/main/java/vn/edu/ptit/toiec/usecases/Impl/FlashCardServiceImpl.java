package vn.edu.ptit.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.ptit.toiec.data.entities.Flashcard;
import vn.edu.ptit.toiec.data.entities.TypeWord;
import vn.edu.ptit.toiec.data.repository.FlashCardRepository;
import vn.edu.ptit.toiec.data.repository.TypeWordRepository;
import vn.edu.ptit.toiec.usecases.FlashCardService;

import java.util.List;
@Service
@Transactional
public class FlashCardServiceImpl implements FlashCardService {
    @Autowired
    private FlashCardRepository flashCardRepository;
    @Autowired
    private TypeWordRepository typeWordRepository;
    @Override
    public List<Flashcard> getAll() {
        List<Flashcard> list = flashCardRepository.findAll();
        for(int i = 0;i < list.size();i++){
            TypeWord typeWord = typeWordRepository.findById(Long.valueOf(list.get(i).getTypeword())).get();
            list.get(i).setTypewordName(typeWord.getName());
        }
        return list;
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
