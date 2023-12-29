package vn.edu.ptit.toiec.presentation.model;

public class HistoryExamRequest {
    private Integer listening_score;
    private Integer reading_score;
    private Integer timeOfExam;
    private Integer examID;

    public HistoryExamRequest() {
    }

    public HistoryExamRequest(Integer listening_score, Integer reading_score, Integer timeOfExam, Integer examID) {
        this.listening_score = listening_score;
        this.reading_score = reading_score;
        this.timeOfExam = timeOfExam;
        this.examID = examID;
    }

    public Integer getListening_score() {
        return listening_score;
    }

    public void setListening_score(Integer listening_score) {
        this.listening_score = listening_score;
    }

    public Integer getReading_score() {
        return reading_score;
    }

    public void setReading_score(Integer reading_score) {
        this.reading_score = reading_score;
    }

    public Integer getTimeOfExam() {
        return timeOfExam;
    }

    public void setTimeOfExam(Integer timeOfExam) {
        this.timeOfExam = timeOfExam;
    }

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }
}
