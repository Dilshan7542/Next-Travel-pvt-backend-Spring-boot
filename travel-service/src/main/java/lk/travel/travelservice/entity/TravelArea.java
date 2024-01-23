package lk.travel.travelservice.entity;

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
public class TravelArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelAreaID;
    @Column(nullable = false)
    private String areaName;
    @Column(nullable = false)
    private double fullKM;
    @OneToMany(mappedBy = "travelArea",targetEntity = Travel.class)
    private List<Travel> travelList;
}
