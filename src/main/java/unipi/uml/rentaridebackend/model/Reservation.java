package unipi.uml.rentaridebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @Column(name = "PENDING")
    private boolean pending;

    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Payment paymentRecord;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<Comment> commments;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<Notification> notifications;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE")
    private LocalDate toDate;


}
