package vn.edu.hnue.toiec.usecases;

import vn.edu.hnue.toiec.core.security.UserPrinciple;
import vn.edu.hnue.toiec.data.entities.User;
import vn.edu.hnue.toiec.presentation.model.LoginRequest;
import vn.edu.hnue.toiec.presentation.model.RegisterRequest;
import vn.edu.hnue.toiec.presentation.model.UserResponse;

import java.util.HashMap;

// Interface định nghĩa các phương thức cơ bản cho việc quản lý đăng ký và đăng nhập người dùng
public interface AuthService {
    // Phương thức đăng ký người dùng mới
    User register(RegisterRequest registerRequest);

    // Phương thức đăng nhập và trả về thông tin người dùng cùng với token
    HashMap<String, Object> login(LoginRequest loginRequest);
}
