package vn.edu.ptit.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.edu.ptit.toiec.core.security.UserPrinciple;
import vn.edu.ptit.toiec.data.entities.HistoryExam;
import vn.edu.ptit.toiec.data.repository.ScoreRepository;
import vn.edu.ptit.toiec.presentation.model.HistoryExamRequest;
import vn.edu.ptit.toiec.presentation.model.HistoryExamResponse;
import vn.edu.ptit.toiec.usecases.HistoryExamService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin("*")
public class HistoryExamController {
    @Autowired
    private HistoryExamService historyExamService;


    @GetMapping()
    public ResponseEntity<List<HistoryExamResponse>> getAll(){
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(historyExamService.getAll(userPrinciple.getId()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody HistoryExamRequest historyExamRequest){
        HistoryExam historyExam = new HistoryExam();
        historyExam.setTimeOfExam(historyExamRequest.getTimeOfExam());
        historyExam.setReading_score(new BigDecimal(historyExamRequest.getReading_score()));
        historyExam.setListening_score(new BigDecimal(historyExamRequest.getListening_score()));
        historyExam.setExamID(historyExamRequest.getExamID());
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        historyExam.setUserID(userPrinciple.getId());
        historyExamService.createHistoryExam(historyExam);
        return ResponseEntity.noContent().build();
    }
}
