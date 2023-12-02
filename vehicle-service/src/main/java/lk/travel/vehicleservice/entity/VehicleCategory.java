package lk.travel.vehicleservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class VehicleCategory implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
   private int vehicleCategoryID;
    @Column(nullable = false)
   private String categoryName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleCategory")
    private List<VehicleBrand> vehicleBrandList;
}
