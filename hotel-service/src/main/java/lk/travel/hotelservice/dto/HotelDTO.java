package lk.travel.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {
   private int hotelID;
   private String name;
   private String email;
   private String location;
   private String map;
   private String tel;
   private byte[] image;
   private int starRate;
   private List<HotelOptionDTO> hotelOption;
}
