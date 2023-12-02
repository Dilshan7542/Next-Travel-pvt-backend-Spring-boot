package lk.travel.hotelservice.entity;

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
@Embeddable
public class HotelOption implements SuperEntity{
   @Column(nullable = false)
   private double option1;
   @Column(nullable = false)
   private double option2;
   @Column(nullable = false)
   private double option3;
   @Column(nullable = false)
   private double option4;
}
