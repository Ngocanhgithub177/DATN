package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.data.entities.Flashcard;

import java.util.List;

public interface FlashCardService {
    public List<Flashcard> getAll();

    public void create(Flashcard flashcard);

    public void update(Flashcard flashcard,Integer id);

    public void delete(Integer id);
}
