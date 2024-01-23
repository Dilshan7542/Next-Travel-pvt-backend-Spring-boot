package lk.travel.travelservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Travel implements SuperEntity{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int travelID ;
    @Column(nullable = false)
    private LocalDate startDate;
    private LocalDate endDate;
    private int countDay;
    private int countNight;
    private int adults;
    private int children;
    private int room;
    private int vehicleCount;
    private int vehicleCost;
    @ManyToOne
    @JoinColumn(name = "travel_area")
    private TravelArea travelArea;
    @ManyToOne
    @JoinColumn(name = "travel_categoryID")
    private TravelCategory travelCategory;
}
