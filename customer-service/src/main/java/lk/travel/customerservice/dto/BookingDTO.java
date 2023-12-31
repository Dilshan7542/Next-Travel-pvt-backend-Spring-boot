package lk.travel.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private int bookingID;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;
    private double paidValue;
    private boolean paymentStatus;
    private String travel;
    private String hotel;
    private String vehicle;
    private String guide;
    private CustomerDTO customer;
}
