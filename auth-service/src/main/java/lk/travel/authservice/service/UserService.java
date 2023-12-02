package lk.travel.authservice.service;

import lk.travel.authservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO searchUser(int userID);
    UserDTO searchByEmailUser(String email);
    void deleteUser(int userID);
    List<UserDTO> getAllUser();

}
