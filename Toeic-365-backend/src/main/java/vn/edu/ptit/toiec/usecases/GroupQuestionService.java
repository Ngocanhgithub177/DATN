package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.data.entities.GroupQuestion;
import vn.edu.ptit.toiec.presentation.model.GroupQuestionRequest;
import vn.edu.ptit.toiec.presentation.model.GroupQuestionResponse;

import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý nhóm câu hỏi
public interface GroupQuestionService {
    // Phương thức tạo mới một nhóm câu hỏi
    GroupQuestion createGroupQuestion(GroupQuestionRequest groupQuestionRequest);

    // Phương thức lấy danh sách tất cả các nhóm câu hỏi dưới dạng các đối tượng GroupQuestionResponse
    List<GroupQuestionResponse> getAllGroupQuestions();

    // Phương thức lấy danh sách tất cả các tiêu đề của nhóm câu hỏi trong một phần cụ thể
    List<GroupQuestionResponse> getAllTitle(String numberPart);

    // Phương thức cập nhật thông tin của một nhóm câu hỏi
    GroupQuestion update(GroupQuestionResponse groupQuestionResponse);

    // Phương thức xóa một nhóm câu hỏi
    GroupQuestion delete(GroupQuestionResponse groupQuestionResponse);
}
