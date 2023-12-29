package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.data.entities.Question;
import vn.edu.ptit.toiec.presentation.model.QuestionRequest;
import vn.edu.ptit.toiec.presentation.model.QuestionResponse;

import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý câu hỏi (Question)
public interface QuestionService {
    // Phương thức tạo mới một câu hỏi
    Question createQuestion(QuestionRequest questionRequest);

    // Phương thức lấy danh sách tất cả các câu hỏi dưới dạng các đối tượng QuestionResponse
    List<QuestionResponse> getAllQuestions();

    // Phương thức cập nhật thông tin của một câu hỏi
    Question update(QuestionResponse questionResponse);

    // Phương thức xóa một câu hỏi
    Question delete(QuestionResponse questionResponse);
}
