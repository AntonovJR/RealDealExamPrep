package softuni.exam.models.dto.xmlDto;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersSeedDto {

    @XmlElement
    @Size(min = 5)
    private String description;
    @XmlElement
    @Positive
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;
    @XmlElement(name = "car")
    private CarIdDto carIdDto;
    @XmlElement(name = "seller")
    private SellerIdDto sellerIdDto;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarIdDto getCarIdDto() {
        return carIdDto;
    }

    public void setCarIdDto(CarIdDto carIdDto) {
        this.carIdDto = carIdDto;
    }

    public SellerIdDto getSellerIdDto() {
        return sellerIdDto;
    }

    public void setSellerIdDto(SellerIdDto sellerIdDto) {
        this.sellerIdDto = sellerIdDto;
    }
}
//<description>kachvash se i karash populace's irrigating advisories exhausting exceptions headphones abdicating
//            diagnostic devastated newsagents wrapping's discount's
//        </description>
//        <price>222359</price>
//        <added-on>2019-12-23 17:02:39</added-on>
//        <has-gold-status>true</has-gold-status>
//        <car>
//            <id>70</id>
//        </car>
//        <seller>
//            <id>84</id>
//        </seller>