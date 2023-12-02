package lk.travel.authservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private int customerID;
    private String nic;
    private String name;
    private String email;
    private String pwd;
    private String address;
    private String tel;
    private byte[] image;
}
