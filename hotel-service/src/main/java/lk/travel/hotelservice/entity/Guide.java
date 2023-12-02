package lk.travel.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicUpdate
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guideID;
    @Pattern(regexp = "^([A-Z]){1,1}[a-z|\\\\s]{1,}$")
    private String name;
    private String address;
    private String tel;
    private double price;
}
