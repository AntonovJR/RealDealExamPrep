package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entities.Seller;
import softuni.exam.models.dto.xmlDto.SellerSeedRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.interfaces.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String SELLER_FILE_PATH = "src/main/resources/files/xml/sellers.xml";
    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser
                .fromFile(SELLER_FILE_PATH, SellerSeedRootDto.class)
                .getSeedDtoList()
                .stream()
                .filter(sellerSeedDto -> {
                    boolean isValid = validationUtil.isValid(sellerSeedDto);
                    stringBuilder.append(isValid ?
                            String.format("Successfully import seller %s - %s%n", sellerSeedDto.getLastName()
                                    , sellerSeedDto.getEmail()) : String.format("Invalid seller%n"));

                    return isValid;
                })
                .map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
                .forEach(sellerRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public Seller getSellerById(Long id) {
        return this.sellerRepository.findById(id).orElse(null);
    }
}
