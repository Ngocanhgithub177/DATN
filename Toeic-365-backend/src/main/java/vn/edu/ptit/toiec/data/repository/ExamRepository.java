package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.ptit.toiec.data.entities.Exam;
import vn.edu.ptit.toiec.data.entities.Part;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam findByPartsContains(Part part);

}