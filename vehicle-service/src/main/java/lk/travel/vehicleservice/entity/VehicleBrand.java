package lk.travel.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleBrand implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int vehicleID;
    @Column(nullable = false)
   private String brandName;
    @Column(nullable = false)
   private int seat;
    @Column(nullable = false)
   private double fee1KM;
    @Column(nullable = false)
   private double fuel1KM;
    @Column(nullable = false)
   private double fee1Day;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
   private byte[] image;
    @ManyToOne
    @JoinColumn(name = "vehicleCategoryID")
   private VehicleCategory vehicleCategory;
}
