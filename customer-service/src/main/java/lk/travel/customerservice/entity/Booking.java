package lk.travel.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private double paidValue;
    @Column(nullable = false)
    private boolean paymentStatus;
    @Column(nullable = false,columnDefinition = "LongText")
    private String hotel;
    @Column(nullable = false,columnDefinition = "LongText")
    private String vehicle;
    @Column(columnDefinition = "LongText")
    private String guide;
    @Column(nullable = false,columnDefinition = "LongText")
    private String travel;
   @ManyToOne
   @JoinColumn(name = "customerID")
    private Customer customer;

}
