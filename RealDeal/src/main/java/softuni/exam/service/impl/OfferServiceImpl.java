package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.dto.xmlDto.OffersSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.interfaces.CarService;
import softuni.exam.service.interfaces.OfferService;
import softuni.exam.service.interfaces.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, ValidationUtil validationUtil, ModelMapper modelMapper,
                            XmlParser xmlParser, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.carService = carService;

        this.sellerService = sellerService;
    }


    @Override
    public boolean areImported() {
        return this.offerRepository.count()>0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser
                .fromFile(OFFERS_FILE_PATH, OffersSeedRootDto.class)
                .getOffersSeedDtos()
                .stream()
                .filter(offersSeedDto -> {
                    boolean isValid = validationUtil.isValid(offersSeedDto);
                    stringBuilder.append(isValid ?
                            String.format("Successfully import offer %s - true%n",offersSeedDto.getAddedOn())
                            : String.format("Invalid offer%n"));

                    return isValid;
                })
                .map(offersSeedDto -> {
                    Offer offer = modelMapper.map(offersSeedDto, Offer.class);
                    offer.setCar(carService.getById(offersSeedDto.getCarIdDto().getId()));
                    offer.setSeller(sellerService.getSellerById(offersSeedDto.getSellerIdDto().getId()));

                    return offer;
                })
                .forEach(offerRepository::save);

        return stringBuilder.toString();
    }
}
