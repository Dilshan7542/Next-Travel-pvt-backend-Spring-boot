package lk.travel.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int userID;
    private String name;
    private String email;
    private String pwd;
    private RoleDTO role;

    public UserDTO(String name, String email, String pwd, RoleDTO role) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }
}
