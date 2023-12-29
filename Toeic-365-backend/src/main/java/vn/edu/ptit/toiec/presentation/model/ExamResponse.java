package vn.edu.ptit.toiec.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponse {

    private Long id;
    private String examName;
    @Column(columnDefinition = "datetime")
    private Date totalTime;

}
