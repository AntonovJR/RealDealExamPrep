package softuni.exam.service.interfaces;


import softuni.exam.models.entities.Car;

import java.io.IOException;

public interface CarService {

    boolean areImported();

    String readCarsFileContent() throws IOException;

    String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();

    Car getById(Long id);
}
