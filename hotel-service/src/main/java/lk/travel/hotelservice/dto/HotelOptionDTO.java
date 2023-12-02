package lk.travel.hotelservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelOptionDTO {
   private double option1;
   private double option2;
   private double option3;
   private double option4;
}
