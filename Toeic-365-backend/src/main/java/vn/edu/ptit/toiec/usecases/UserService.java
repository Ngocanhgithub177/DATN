package vn.edu.ptit.toiec.usecases;

import vn.edu.ptit.toiec.core.security.UserPrinciple;
import vn.edu.ptit.toiec.data.entities.User;

import java.util.List;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý người dùng (User)
public interface UserService {
    // Phương thức lấy danh sách tất cả người dùng dưới dạng các đối tượng UserPrinciple
    List<UserPrinciple> getAllUser();

    // Phương thức xóa một người dùng
    void delete(User user);

    // Phương thức lấy thông tin người dùng hiện tại
    UserPrinciple getCurrentUser();

    // Phương thức cập nhật thông tin người dùng
    User update(User user);

    List<UserPrinciple> getAllRegisteredUser();

}
