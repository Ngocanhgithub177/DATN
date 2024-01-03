package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.ptit.toiec.data.entities.Score;

public interface ScoreRepository extends JpaRepository<Score,Integer> {
    @Query(value = "Select number_of_score from score where `check` = ?1 and `type` = ?2",nativeQuery = true)
    public int getScore(int check,int type);
}
