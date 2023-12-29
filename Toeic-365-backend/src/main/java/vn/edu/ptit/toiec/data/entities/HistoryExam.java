package vn.edu.ptit.toiec.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history_exam")
public class HistoryExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "listening_score")
    private BigDecimal listening_score;
    @Column(name = "reading_score")
    private BigDecimal reading_score;
    @Column(name = "time_of_exam")
    private Integer timeOfExam;
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "exam_id")
    private Integer examID;
}