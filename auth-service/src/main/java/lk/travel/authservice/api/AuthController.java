package lk.travel.authservice.api;

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
        System.out.println("is Hereeeee........");
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping(path = "/customer/register")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("Customer Register Method Invoked");
        customerDTO.setPwd(passwordEncoder.encode(customerDTO.getPwd()));
        Mono<CustomerDTO> customerDTOMono = WebClient.create("http://localhost:8082/api/v1/customer/register")
                .post().body(Mono.just(customerDTO), CustomerDTO.class).retrieve()
                .bodyToMono(CustomerDTO.class);
        customerDTOMono.onErrorResume(e-> Mono.error(new RuntimeException(e)));
        if (customerDTOMono.block()!=null) {
            userService.saveUser(new UserDTO(customerDTO.getName(),customerDTO.getEmail(),customerDTO.getPwd(), RoleDTO.USER));
        System.out.println("Customer Ok.......!!!!");
        return new ResponseEntity<>(customerDTOMono.block(),HttpStatus.OK);
        }
        System.out.println("Test Error..!!!");
        throw new RuntimeException("ERROR......!!");
    }
}
