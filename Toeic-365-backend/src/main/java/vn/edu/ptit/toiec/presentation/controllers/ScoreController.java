package vn.edu.ptit.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.ptit.toiec.core.security.UserPrinciple;
import vn.edu.ptit.toiec.data.entities.Score;
import vn.edu.ptit.toiec.data.repository.ScoreRepository;
import vn.edu.ptit.toiec.presentation.model.HistoryExamResponse;

import java.util.List;

@RestController
@RequestMapping("/api/score")
@CrossOrigin("*")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping()
    public ResponseEntity<List<Score>> getAll(){
        return new ResponseEntity<>(scoreRepository.findAll(), HttpStatus.OK);
    }
}
