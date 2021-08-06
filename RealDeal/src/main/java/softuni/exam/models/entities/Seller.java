package softuni.exam.models.entities;

import softuni.exam.models.enums.Rating;

import javax.persistence.*;

@Entity(name = "sellers")
public class Seller extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    private String town;


    public Seller() {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
//•	id – integer number, primary identification field.
//•	firstName – a char sequence (between 2 to 20 exclusive).
//•	lastName – a char sequence (between 2 to 20 exclusive).
//•	email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
//•	rating – enumerated value must be one of these GOOD, BAD or UNKNOWN. Cannot be null.
//•	town – a char sequence – the name of a town. Cannot be null.