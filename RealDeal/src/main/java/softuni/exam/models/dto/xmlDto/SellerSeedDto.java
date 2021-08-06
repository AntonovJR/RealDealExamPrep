package softuni.exam.models.dto.xmlDto;

import softuni.exam.models.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {

    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19)
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 2, max = 19)
    private String lastName;
    @XmlElement(name = "email")
    @Email
    private String email;
    @XmlElement(name = "rating")
    @NotNull
    private Rating rating;
    @XmlElement(name = "town")
    @NotBlank
    private String town;

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
// <first-name>Wade</first-name>
//        <last-name>F</last-name>
//        <email>wforseith1@umich.edu</email>
//        <rating>GOOD</rating>
//        <town>Juhut</town>