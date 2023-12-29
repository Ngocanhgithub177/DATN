package vn.edu.ptit.toiec.presentation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.ptit.toiec.data.entities.TypeWord;
import vn.edu.ptit.toiec.data.repository.TypeWordRepository;
import vn.edu.ptit.toiec.usecases.FlashCardService;

import java.util.List;

@RestController
@RequestMapping("/api/typeword")
@CrossOrigin("*")
@AllArgsConstructor
public class TypeWordController {
    @Autowired
    private final TypeWordRepository typeWordRepository;

    @GetMapping()
    private ResponseEntity<List<TypeWord>> getAll(){
        return ResponseEntity.ok(typeWordRepository.findAll());
    }
}
