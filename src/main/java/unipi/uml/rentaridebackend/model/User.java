package unipi.uml.rentaridebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME")
    @NotNull(message = "Username is mandatory")
    @Size(min = 6, max = 50)
    private String userName;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password is mandatory")
    @Size(min = 6, max = 50)
    private String password;

    @Column(name = "FIRST_NAME")
    @NotNull(message = "First name is mandatory")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotNull(message = "Last name is mandatory")
    private String lastName;

    @Column(name = "MOBILE")
    private String mobilePhone;

    @Column(name = "EMAIL", unique = true)
    @NotNull(message = "Email is mandatory")
    private String email;

    @Column(name = "AGE")
    @NotNull(message = "Age is mandatory")
    private int age;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> userRoles;

}
