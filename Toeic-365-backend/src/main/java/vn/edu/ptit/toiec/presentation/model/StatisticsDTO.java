package vn.edu.ptit.toiec.presentation.model;

public class StatisticsDTO {
    private Integer numberAccounts;
    private Integer numberRegisteredAccounts;
    private Integer numberExam;
    private Integer numberQuestion;

    public StatisticsDTO() {
    }

    public StatisticsDTO(Integer numberAccounts, Integer numberRegisteredAccounts, Integer numberExam, Integer numberQuestion) {
        this.numberAccounts = numberAccounts;
        this.numberRegisteredAccounts = numberRegisteredAccounts;
        this.numberExam = numberExam;
        this.numberQuestion = numberQuestion;
    }

    public Integer getNumberAccounts() {
        return numberAccounts;
    }

    public void setNumberAccounts(Integer numberAccounts) {
        this.numberAccounts = numberAccounts;
    }

    public Integer getNumberRegisteredAccounts() {
        return numberRegisteredAccounts;
    }

    public void setNumberRegisteredAccounts(Integer numberRegisteredAccounts) {
        this.numberRegisteredAccounts = numberRegisteredAccounts;
    }

    public Integer getNumberExam() {
        return numberExam;
    }

    public void setNumberExam(Integer numberExam) {
        this.numberExam = numberExam;
    }

    public Integer getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(Integer numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
}
