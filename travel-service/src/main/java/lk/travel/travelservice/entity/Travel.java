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
    private int noAdults;
    private int children;
    private int headCount;
    private int pets;
    private int guide;
    private double paidValue;
    private String remark;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "travel_location",joinColumns = @JoinColumn(name = "travelID"))
    private List<TravelLocation> travelLocationList;
    @ManyToOne
    @JoinColumn(name = "travel_categoryID")
    private TravelCategory travelCategory;
}
