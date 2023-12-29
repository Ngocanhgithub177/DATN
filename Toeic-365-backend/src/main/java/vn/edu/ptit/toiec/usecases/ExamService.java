package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.data.entities.Exam;
import vn.edu.ptit.toiec.presentation.model.ExamDTO;
import vn.edu.ptit.toiec.presentation.model.ExamRequest;
import vn.edu.ptit.toiec.presentation.model.ExamResponse;

import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý đề thi
public interface ExamService {
    // Phương thức tạo đề thi mới
    Exam create(ExamRequest examRequest);

    // Phương thức lấy thông tin đề thi theo ID
    ExamDTO getExamById(Long id);

    // Phương thức lấy danh sách tất cả các đề thi
    List<Exam> getAllExams();

    // Phương thức lấy danh sách đề thi dưới dạng các đối tượng ExamResponse
    List<ExamResponse> getAllExam();

    // Phương thức lấy thông tin đề thi theo ID dưới dạng đối tượng ExamResponse
    ExamResponse getIntroExamById(Long id);

    // Phương thức cập nhật thông tin đề thi
    Exam update(ExamRequest examRequest);

    // Phương thức xóa đề thi
    Exam delete(Exam exam);
}
