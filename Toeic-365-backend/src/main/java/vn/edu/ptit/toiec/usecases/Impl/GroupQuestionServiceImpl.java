package vn.edu.ptit.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.ptit.toiec.data.entities.GroupQuestion;
import vn.edu.ptit.toiec.data.entities.Part;
import vn.edu.ptit.toiec.data.repository.GroupQuestionRepository;
import vn.edu.ptit.toiec.data.repository.PartRepository;
import vn.edu.ptit.toiec.presentation.model.GroupQuestionRequest;
import vn.edu.ptit.toiec.presentation.model.GroupQuestionResponse;
import vn.edu.ptit.toiec.usecases.GroupQuestionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupQuestionServiceImpl implements GroupQuestionService {

    @Autowired
    private GroupQuestionRepository groupQuestionRepository;

    @Autowired
    private PartRepository partRepository;

    @Override
    // Phương thức tạo mới nhóm câu hỏi
    public GroupQuestion createGroupQuestion(GroupQuestionRequest groupQuestionRequest) {
        GroupQuestion groupQuestion = new GroupQuestion();

        // Kiểm tra xem tiêu đề nhóm câu hỏi đã tồn tại chưa
        if (groupQuestionRepository.existsByTitle(groupQuestionRequest.getTitle())) {
            throw new RuntimeException("Tiêu đề nhóm câu hỏi đã tồn tại");
        }

        groupQuestion.setTitle(groupQuestionRequest.getTitle());
        groupQuestion.setGroupQuestionDesc(groupQuestionRequest.getGroupQuestionDesc());
        groupQuestion.setAudio(groupQuestionRequest.getAudio());
        groupQuestion.setGroupQuestionImg(groupQuestionRequest.getGroupQuestionImg());
        groupQuestion.setParagraph(groupQuestionRequest.getParagraph());

        // Tìm phần theo số thứ tự và gán cho nhóm câu hỏi
        Part part = partRepository.findTopByNumberPart(groupQuestionRequest.getNumberPart());
        groupQuestion.setPart(part);

        groupQuestionRepository.save(groupQuestion);

        return groupQuestion;
    }

    @Override
    // Phương thức lấy danh sách tất cả các nhóm câu hỏi và số thứ tự phần tương ứng
    public List<GroupQuestionResponse> getAllGroupQuestions() {
        List<GroupQuestionResponse> groupQuestions = groupQuestionRepository.findNumberPartAndAllGroupQuestion();
        return groupQuestions;
    }

    @Override
    // Phương thức lấy danh sách tiêu đề của tất cả các nhóm câu hỏi trong một phần
    public List<GroupQuestionResponse> getAllTitle(String numberPart) {
        List<GroupQuestionResponse> groupQuestions = groupQuestionRepository.findAllTitleByNumberPart(numberPart);
        return groupQuestions;
    }

    @Override
    // Phương thức cập nhật thông tin của một nhóm câu hỏi
    public GroupQuestion update(GroupQuestionResponse groupQuestionResponse) {
        GroupQuestion groupQuestion = groupQuestionRepository.findById(groupQuestionResponse.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ID của nhóm câu hỏi"));

        if (groupQuestion != null) {
            // Kiểm tra xem tiêu đề mới đã tồn tại chưa
            if (groupQuestionRepository.existsByTitle(groupQuestionResponse.getTitle())) {
                throw new RuntimeException("Tiêu đề nhóm câu hỏi đã tồn tại");
            }

            groupQuestion.setTitle(groupQuestionResponse.getTitle());
            groupQuestion.setGroupQuestionDesc(groupQuestionResponse.getGroupQuestionDesc());
            groupQuestion.setGroupQuestionImg(groupQuestionResponse.getGroupQuestionImg());
            groupQuestion.setAudio(groupQuestionResponse.getAudio());
            groupQuestion.setParagraph(groupQuestionResponse.getParagraph());

            groupQuestionRepository.save(groupQuestion);
        }

        return groupQuestion;
    }

    @Override
    // Phương thức xóa một nhóm câu hỏi
    public GroupQuestion delete(GroupQuestionResponse groupQuestionResponse) {
        GroupQuestion groupQuestion = groupQuestionRepository.findById(groupQuestionResponse.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ID của nhóm câu hỏi"));

        if (groupQuestion != null) {
            groupQuestionRepository.delete(groupQuestion);
        }

        return groupQuestion;
    }

    // Phương thức chuyển đổi danh sách nhóm câu hỏi thành danh sách chỉ chứa tiêu đề
    public List<GroupQuestionResponse> convertToTitle(List<GroupQuestion> groupQuestions) {
        List<GroupQuestionResponse> groupQuestionResponses = new ArrayList<>();

        for (GroupQuestion groupQuestion : groupQuestions) {
            groupQuestionResponses.add(new GroupQuestionResponse(groupQuestion.getTitle()));
        }

        return groupQuestionResponses;
    }
}
