package vn.edu.ptit.toiec.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.ptit.toiec.data.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String fullName;
    private String email;
    private String password;

    public User convertToUser(){
        User user = new User();
        user.setFullName(this.fullName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
