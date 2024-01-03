package vn.edu.ptit.toiec.presentation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.ptit.toiec.data.entities.Flashcard;
import vn.edu.ptit.toiec.usecases.FileUpload;
import vn.edu.ptit.toiec.usecases.FlashCardService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/flashcard")
@CrossOrigin("*")
@AllArgsConstructor
public class FlashCardController {
    @Autowired
    private final FlashCardService flashCardService;

    @Autowired
    private final FileUpload fileUpload;

    @GetMapping()
    public ResponseEntity<List<Flashcard>> getAll(){
        return new ResponseEntity<>(flashCardService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create",consumes = {"multipart/form-data"})
    public ResponseEntity<Flashcard> create(@RequestParam("image") MultipartFile image,
                                            @RequestParam("word") String word,
                                            @RequestParam("content") String content,
                                            @RequestParam("nouns") String nouns,
                                            @RequestParam("typeword") Integer typeword)
    {
        try {
            String file = fileUpload.uploadFile(image);
            Flashcard flashcard = new Flashcard();
            flashcard.setTypeword(typeword);
            flashcard.setNouns(nouns);
            flashcard.setContent(content);
            flashcard.setWord(word);
            flashcard.setImage(file);
            flashCardService.create(flashcard);
            return new ResponseEntity<>(flashcard,HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Flashcard> update(@RequestParam("image") MultipartFile image,
                                            @RequestParam("word") String word,
                                            @RequestParam("content") String content,
                                            @RequestParam("nouns") String nouns,
                                            @RequestParam("typeword") Integer typeword,
                                            @RequestParam("id") Integer id)
    {
        try {
            String file = fileUpload.uploadFile(image);
            Flashcard flashcard = new Flashcard();
            flashcard.setTypeword(typeword);
            flashcard.setNouns(nouns);
            flashcard.setContent(content);
            flashcard.setWord(word);
            flashcard.setImage(file);
            flashCardService.update(flashcard,id);
            return new ResponseEntity<>(flashcard,HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id)
    {
       flashCardService.delete(id);
       return ResponseEntity.noContent().build();
    }
}
