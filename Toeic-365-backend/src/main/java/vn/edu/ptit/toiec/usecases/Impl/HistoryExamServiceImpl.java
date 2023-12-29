package vn.edu.ptit.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.ptit.toiec.data.entities.HistoryExam;
import vn.edu.ptit.toiec.data.repository.ExamRepository;
import vn.edu.ptit.toiec.data.repository.HistoryExamRepository;
import vn.edu.ptit.toiec.presentation.model.HistoryExamResponse;
import vn.edu.ptit.toiec.usecases.HistoryExamService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HistoryExamServiceImpl implements HistoryExamService {
    @Autowired
    private HistoryExamRepository historyExamRepository;
    @Autowired
    private ExamRepository examRepository;
    @Override
    public void createHistoryExam(HistoryExam historyExam) {
        historyExamRepository.save(historyExam);
    }

    @Override
    public List<HistoryExamResponse> getAll(Integer userID) {
        List<HistoryExam> exams = historyExamRepository.findByUser(userID);
        List<HistoryExamResponse> list = new ArrayList<>();
        for(HistoryExam i : exams){
            HistoryExamResponse historyExamResponse = new HistoryExamResponse();
            historyExamResponse.setListening_score(i.getListening_score().intValue());
            historyExamResponse.setReading_score(i.getReading_score().intValue());
            historyExamResponse.setTimeOfExam(i.getTimeOfExam());
            historyExamResponse.setExamName(examRepository.findById(Long.valueOf(i.getExamID())).get().getExamName());
            list.add(historyExamResponse);
        }
        return list;
    }


}
