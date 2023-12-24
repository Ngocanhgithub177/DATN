package vn.edu.hnue.toiec.usecases;

import org.springframework.web.multipart.MultipartFile;
import vn.edu.hnue.toiec.data.entities.Exam;

import java.io.InputStream;
import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý dữ liệu từ tệp Excel
public interface ExcelService {
    // Phương thức kiểm tra xem tệp có định dạng Excel hay không
    boolean isExcelFormat(MultipartFile file);

    // Phương thức lưu dữ liệu từ tệp Excel vào cơ sở dữ liệu
    void save(MultipartFile file);

    // Phương thức chuyển đổi dữ liệu từ InputStream của tệp Excel thành danh sách các đối tượng Exam
    List<Exam> convertToExam(InputStream inputStream);
}
