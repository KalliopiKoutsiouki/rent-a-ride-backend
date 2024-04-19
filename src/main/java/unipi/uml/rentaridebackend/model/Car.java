package unipi.uml.rentaridebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "FROM")
    private Date from;

    @Column(name = "TO")
    private Date to;

    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Reservation reservation;

    @JsonIgnore
    @OneToOne(mappedBy = "car")
    private Comment comment;
}
