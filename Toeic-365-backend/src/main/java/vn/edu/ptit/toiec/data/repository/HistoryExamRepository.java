package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.ptit.toiec.data.entities.HistoryExam;

import java.util.List;

public interface HistoryExamRepository extends JpaRepository<HistoryExam,Long> {
    @Query(value = "SELECT * FROM toiec365.history_exam where user_id = ?1",nativeQuery = true)
    public List<HistoryExam> findByUser(Integer userID);
}
