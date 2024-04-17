package unipi.uml.rentaridebackend.model;

public enum UserRole {

    ROLE_USER ("ROLE_USER"),
    ROLE_ADMIN ("ROLE_ADMIN"),
    ROLE_RENTER ("ROLE_RENTER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
