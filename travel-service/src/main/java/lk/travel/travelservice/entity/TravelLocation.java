package lk.travel.travelservice.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class TravelLocation implements SuperEntity{
    private String travelAreaName;
    private String remark;
}
