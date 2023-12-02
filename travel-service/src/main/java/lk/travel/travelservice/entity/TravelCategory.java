package lk.travel.travelservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TravelCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelCategoryID;
    @Column(nullable = false)
    private String categoryName;
    @JsonIgnore
    @OneToMany(mappedBy = "travelCategory")
    private List<Travel> travelList;
}
