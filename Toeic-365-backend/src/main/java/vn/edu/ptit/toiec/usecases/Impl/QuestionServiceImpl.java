package vn.edu.ptit.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.ptit.toiec.data.entities.GroupQuestion;
import vn.edu.ptit.toiec.data.entities.Question;
import vn.edu.ptit.toiec.data.repository.GroupQuestionRepository;
import vn.edu.ptit.toiec.data.repository.QuestionRepository;
import vn.edu.ptit.toiec.presentation.model.QuestionRequest;
import vn.edu.ptit.toiec.presentation.model.QuestionResponse;
import vn.edu.ptit.toiec.usecases.QuestionService;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private GroupQuestionRepository groupQuestionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
// Phương thức tạo mới một câu hỏi
    public Question createQuestion(QuestionRequest questionRequest) {
        Question question = new Question();

        // Đặt thông tin cho câu hỏi từ dữ liệu đầu vào
        question.setQuestionNumber(questionRequest.getQuestionNumber());
        question.setQuestionContent(questionRequest.getQuestionContent());
        question.setQuestionImg(questionRequest.getQuestionImg());
        question.setOption1(questionRequest.getOption1());
        question.setOption2(questionRequest.getOption2());
        question.setOption3(questionRequest.getOption3());
        question.setOption4(questionRequest.getOption4());
        question.setCorrectAnswer(questionRequest.getCorrectAnswer());
        question.setDetailedAnswer(questionRequest.getDetailedAnswer());

        // Tìm nhóm câu hỏi bằng tiêu đề
        GroupQuestion groupQuestion = groupQuestionRepository.findByTitle(questionRequest.getTitle());

        // Liên kết câu hỏi với nhóm câu hỏi
        question.setGroupQuestion(groupQuestion);
        questionRepository.save(question);

        return question;
    }

    @Override
    // Lấy danh sách tất cả các câu hỏi
    public List<QuestionResponse> getAllQuestions() {
        List<QuestionResponse> questionResponses = questionRepository.getAllQuestions();
        return questionResponses;
    }

    @Override
// Phương thức cập nhật thông tin của một câu hỏi
    public Question update(QuestionResponse questionResponse) {
        Question question = questionRepository.findById(questionResponse.getId()).orElseThrow(() -> new RuntimeException("ID KHÔNG TÌM THẤY"));

        // Cập nhật thông tin của câu hỏi
        if (question != null) {
            question.setQuestionNumber(questionResponse.getQuestionNumber());
            question.setQuestionContent(questionResponse.getQuestionContent());
            question.setQuestionImg(questionResponse.getQuestionImg());
            question.setOption1(questionResponse.getOption1());
            question.setOption2(questionResponse.getOption2());
            question.setOption3(questionResponse.getOption3());
            question.setOption4(questionResponse.getOption4());
            question.setCorrectAnswer(questionResponse.getCorrectAnswer());
            question.setDetailedAnswer(questionResponse.getDetailedAnswer());
        }

        questionRepository.save(question);

        return question;
    }


    @Override
    // Phương thức xóa một câu hỏi
    public Question delete(QuestionResponse questionResponse) {
        Question question = questionRepository.findById(questionResponse.getId()).orElseThrow(() -> new RuntimeException("ID KHÔNG TÌM THẤY"));

        // Xóa câu hỏi
        if (question != null) {
            questionRepository.delete(question);
        }

        return question;
    }
}
