package unipi.uml.rentaridebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CAR")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PLATE")
    private String plateNo;

    @Column(name = "PICTURE_URL")
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User leaser;

    @Column(name = "IS_AVAILABLE")
    private boolean isAvailable;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE")
    private LocalDate toDate;

    @JsonIgnore
    @OneToOne(mappedBy = "car")
    private Reservation reservation;

    @JsonIgnore
    @OneToOne(mappedBy = "car")
    private Comment comment;
}
