package unipi.uml.rentaridebackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RENTER")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Renter extends User{


    @OneToOne(mappedBy = "renter")
    private Reservation reservation;

//    @Column(name = "YEARS_DRIVING")
//    private int yearsDriving;

}
