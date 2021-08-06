package softuni.exam.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "offers")
public class Offer extends BaseEntity{

    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "has_gold_status")
    private Boolean hasGoldStatus;
    @Column(name = "added_on")
    private LocalDateTime addedOn;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Seller seller;
    @ManyToMany(mappedBy = "offerList")
    private Set<Picture> pictureList;


    public Offer() {
    }

    public Set<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(Set<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
