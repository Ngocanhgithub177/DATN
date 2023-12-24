package vn.edu.hnue.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hnue.toiec.core.security.CustomAuthenticationProvider;
import vn.edu.hnue.toiec.core.security.JwtProvider;
import vn.edu.hnue.toiec.core.security.UserPrinciple;
import vn.edu.hnue.toiec.data.entities.Authority;
import vn.edu.hnue.toiec.data.entities.AuthorityName;
import vn.edu.hnue.toiec.data.entities.User;
import vn.edu.hnue.toiec.data.repository.AuthorityRepository;
import vn.edu.hnue.toiec.data.repository.UserRepository;
import vn.edu.hnue.toiec.presentation.model.LoginRequest;
import vn.edu.hnue.toiec.presentation.model.RegisterRequest;
import vn.edu.hnue.toiec.presentation.model.UserResponse;
import vn.edu.hnue.toiec.usecases.AuthService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

    // Inject các repository và dịch vụ cần thiết
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Autowired
    private AuthorityRepository AuthorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    // Phương thức đăng ký người dùng
    public User register(RegisterRequest registerRequest) {
        // Kiểm tra xem email đã tồn tại chưa
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }
        // Chuyển đổi từ RegisterRequest sang đối tượng User
        User user = registerRequest.convertToUser();
        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        // Đặt quyền của người dùng là ROLE_USER
        Authority authority = AuthorityRepository.findAllByName(AuthorityName.ROLE_USER);
        user.setRoles(new HashSet<Authority>() {{
            add(authority);
        }});
        // Lưu đối tượng User vào cơ sở dữ liệu
        userRepository.save(user);
        return user;
    }

    // Phương thức đăng nhập người dùng
    public HashMap<String, Object> login(LoginRequest loginRequest) {
        HashMap<String, Object> result = new HashMap<>();
        // Xác thực thông tin đăng nhập của người dùng
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        // Đặt người dùng đã xác thực vào SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Tạo mã JWT cho người dùng
        String token = jwtProvider.generateTokenByUsername(loginRequest.getEmail());
        // Điền thông tin người dùng và mã JWT vào map kết quả
        result.put("userInfo", authentication.getPrincipal());
        result.put("token", token);
        return result;
    }
}
