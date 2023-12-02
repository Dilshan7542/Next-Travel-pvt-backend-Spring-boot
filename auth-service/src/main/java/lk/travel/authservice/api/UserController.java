package lk.travel.authservice.api;

import lk.travel.authservice.dto.UserDTO;
import lk.travel.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        return ResponseEntity.ok(userService.saveUser(userDTO)); // Response ok Mono work
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @GetMapping(path = "search/email", params = "email")
    public ResponseEntity<UserDTO> searchByEmailUser(@RequestParam String email) {
        UserDTO userDTO = userService.searchByEmailUser(email);
        System.out.println("email : "+userDTO.getName());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<UserDTO> searchByIDUser(@RequestParam int userID) {
        return ResponseEntity.ok(userService.searchUser(userID));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }
    @DeleteMapping(path = "{userID}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int userID){
        userService.deleteUser(userID);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
