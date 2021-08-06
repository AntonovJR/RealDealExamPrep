package softuni.exam.models.dto.xmlDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersSeedRootDto {

    @XmlElement(name = "offer")
    private List<OffersSeedDto> offersSeedDtos;

    public List<OffersSeedDto> getOffersSeedDtos() {
        return offersSeedDtos;
    }

    public void setOffersSeedDtos(List<OffersSeedDto> offersSeedDtos) {
        this.offersSeedDtos = offersSeedDtos;
    }
}
