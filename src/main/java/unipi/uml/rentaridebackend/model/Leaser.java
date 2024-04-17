package unipi.uml.rentaridebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "LEASER")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Leaser extends User {

    @JsonIgnore
    @OneToMany(mappedBy = "leaser")
    private List<Car> carList;
}
