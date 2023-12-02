package lk.travel.hotelservice.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate
@ToString
public class Hotel implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int hotelID;
    @Column(nullable = false)
   private String name;
    @Column(nullable = false)
   private String email;
   private String location;
   private String map;
   private String tel;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
   private byte[] image;
    @Column(nullable = false)
   private int starRate;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hotel_option",joinColumns = @JoinColumn(name = "hotelID"))
   private List<HotelOption> hotelOption;
}
