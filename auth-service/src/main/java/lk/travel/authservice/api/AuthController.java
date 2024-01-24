package lk.travel.authservice.api;

import lk.travel.authservice.constant.SecurityConstant;
import lk.travel.authservice.dto.CustomerDTO;
import lk.travel.authservice.dto.RoleDTO;
import lk.travel.authservice.dto.UserDTO;
import lk.travel.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(path = "/**")
    public ResponseEntity<Boolean> allAuthRequest(){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping(path = "/customer/register")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerDTO.setPwd(passwordEncoder.encode(customerDTO.getPwd()));
        CustomerDTO block = WebClient.create(SecurityConstant.CUSTOMER_URL +"/register")
                .post().body(Mono.just(customerDTO), CustomerDTO.class).retrieve()
                .bodyToMono(CustomerDTO.class).block();
        if (block!=null) {
            UserDTO userDTO = userService.saveUser(new UserDTO(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPwd(), RoleDTO.USER));
            if (userDTO!=null) {
        return new ResponseEntity<>(block,HttpStatus.OK);
            }
            WebClient.create(SecurityConstant.CUSTOMER_URL+"/"+customerDTO.getCustomerID()).delete().retrieve().toEntity(Void.class);
        }
        throw new RuntimeException("ERROR......!!");
    }
    @GetMapping(path = "/customer/search/email/{email}")
    public ResponseEntity<CustomerDTO> searchCustomerByEmail(@PathVariable String email)throws Exception{
        CustomerDTO body = WebClient.create(SecurityConstant.CUSTOMER_URL + "/search/email/" + email).get().retrieve().toEntity(CustomerDTO.class).block().getBody();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
