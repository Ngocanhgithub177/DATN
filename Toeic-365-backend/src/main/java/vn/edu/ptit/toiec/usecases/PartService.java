package vn.edu.ptit.toiec.usecases;

import org.springframework.data.jpa.domain.Specification;
import vn.edu.ptit.toiec.data.entities.Part;
import vn.edu.ptit.toiec.presentation.model.PartRequest;
import vn.edu.ptit.toiec.presentation.model.PartResponse;

import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý phần thi (Part)
public interface PartService {
    // Phương thức tạo mới một phần thi
    Part createPart(PartRequest partRequest);

    // Phương thức cập nhật thông tin của một phần thi
    Part updatePart(PartRequest partRequest);

    // Phương thức xóa một phần thi
    Part delete(PartResponse partResponse);

    // Phương thức lấy danh sách tất cả các phần thi dưới dạng các đối tượng PartResponse
    List<PartResponse> getAllParts();

    // Phương thức lấy danh sách tất cả các số phần thi
    List<PartResponse> getAllNumberPart();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 1
    List<PartResponse> getAllNumberPartOne();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 2
    List<PartResponse> getAllNumberPartTwo();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 3
    List<PartResponse> getAllNumberPartThree();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 4
    List<PartResponse> getAllNumberPartFour();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 5
    List<PartResponse> getAllNumberPartFive();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 6
    List<PartResponse> getAllNumberPartSix();

    // Phương thức lấy danh sách tất cả các số phần thi của Part 7
    List<PartResponse> getAllNumberPartSeven();

    // Phương thức tìm kiếm các phần thi theo từ khóa
    Specification<Part> searchAllPart(String keyword);
}
