package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "pictures")
public class Picture extends BaseEntity {
    private String name;
    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;
    @ManyToOne
    private Car car;
    @ManyToMany
    private Set<Offer> offerList;

    public Picture() {
    }

    public Set<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(Set<Offer> offerList) {
        this.offerList = offerList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
//•	name – a char sequence (between 2 to 20 exclusive). The name of a picture is unique.
//•	dateAndTime – The date and time of a picture.