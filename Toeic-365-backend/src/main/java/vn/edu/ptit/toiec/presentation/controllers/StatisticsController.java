package vn.edu.ptit.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.ptit.toiec.presentation.model.StatisticsDTO;
import vn.edu.ptit.toiec.usecases.ExamService;
import vn.edu.ptit.toiec.usecases.QuestionService;
import vn.edu.ptit.toiec.usecases.UserService;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin("*")
public class StatisticsController {
    @Autowired
    private ExamService examService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @GetMapping()
    public ResponseEntity<StatisticsDTO> getDataStatistics(){
        int numberOfExams = examService.getAllExams().size();
        int numberOfUsers = userService.getAllUser().size();
        int numberOfRegisteredAccount = userService.getAllRegisteredUser().size();
        int numberOfQuestions = questionService.getAllQuestions().size();
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsDTO.setNumberAccounts(numberOfUsers);
        statisticsDTO.setNumberExam(numberOfExams);
        statisticsDTO.setNumberRegisteredAccounts(numberOfRegisteredAccount);
        statisticsDTO.setNumberQuestion(numberOfQuestions);
        return new ResponseEntity<>(statisticsDTO, HttpStatus.OK);
    }
}
