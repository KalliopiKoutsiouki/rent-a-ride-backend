package unipi.uml.rentaridebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User renter;

    @OneToOne
    @JoinColumn(name = "CAR_ID", referencedColumnName = "id")
    private Car car;

    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Payment paymentRecord;

//    @Column(name = "FROM")
//    private Date from;
//
//    @Column(name = "TO")
//    private Date to;


}
