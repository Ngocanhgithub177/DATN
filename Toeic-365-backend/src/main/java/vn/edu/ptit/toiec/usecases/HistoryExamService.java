package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.data.entities.HistoryExam;
import vn.edu.ptit.toiec.presentation.model.HistoryExamResponse;

import java.util.List;

public interface HistoryExamService {

    public void createHistoryExam(HistoryExam historyExam);

    public List<HistoryExamResponse> getAll(Integer userID);

}
