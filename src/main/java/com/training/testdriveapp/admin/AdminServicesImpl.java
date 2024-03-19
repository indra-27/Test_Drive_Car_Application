package com.training.testdriveapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    private CarRepository carsRepository;

    @Override
    public Car addNewCar(CarDto newCars) throws AdminException{
        if(newCars.getModelName() == null||newCars.getCompany() == null||newCars.getCarPrice()==null||newCars.getColor()==null||newCars.getMileage()==null||newCars.getRpm()==null||newCars.getSeater()==null||newCars.getFuelType()==null||newCars.getVehicleType()==null||newCars.getEngineModel()==null)
        {
            throw new AdminException("Car details cannot be null");
        }
        Car findCar = getCarDetailsByModelName(newCars.getModelName());
        if(findCar != null)
        {
            throw new AdminException("Car already exist");
        }
        Car car = new Car();
        car.setCarPrice(newCars.getCarPrice());
        car.setColor(newCars.getColor());
        car.setCompany(newCars.getCompany());
        car.setEngineModel(newCars.getEngineModel());
        car.setFuelType(newCars.getFuelType());
        car.setModelName(newCars.getModelName());
        car.setMileage(newCars.getMileage());
        car.setRpm(newCars.getRpm());
        car.setSeater(newCars.getSeater());
        car.setVehicleType(newCars.getVehicleType());
        return this.carsRepository.save(car);
    }

    @Override
    public Car getCarDetailsByModelName(String modelName) throws AdminException {
        if(modelName == null){
            throw new AdminException("Model name cannot be null");
        }
        Car foundModel = this.carsRepository.findByModelName(modelName);
        if(foundModel == null) {
            throw new AdminException("No such model exists");
        }
        return this.carsRepository.findByModelName(modelName);
    }

    @Override
    public Car updateCarDetails(Car updateCar) throws AdminException {
        if(updateCar == null)
        {
            throw new AdminException("Null car details cannot be updated");
        }
        if(updateCar.getCarId()==null)
        {
            throw new AdminException("Car ID is mandatory to update the car");
        }
        Optional<Car> foundCarId = this.carsRepository.findById(updateCar.getCarId());
        if(foundCarId == null)
        {
            throw new AdminException("Car ID not found");
        }
        return this.carsRepository.save(updateCar);
    }

    @Override
    public Car deleteCarById(Integer carId) throws AdminException {
        Optional<Car> foundCar = this.carsRepository.findById(carId);
        if(foundCar.isPresent()) {
            this.carsRepository.deleteById(carId);
        }
        return null;
    }

    @Override
    public List<Car> getCarDetailsByCompany(String company) throws AdminException {
        if(company == null){
            throw new AdminException("Give a valid Company name");
        }
        List<Car> foundCompany = this.carsRepository.findByCompany(company);
        if(foundCompany == null){
            throw new AdminException("No such Car Company exists");
        }
        return this.carsRepository.findByCompany(company);
    }


    @Override
    public List<Car> getCarDetailsWithinPriceRange(Double minprice, Double maxprice) {
        return this.getAllCars().stream().filter((s)->s.getCarPrice()>=minprice&&s.getCarPrice()<=maxprice).collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCars() {
        return this.carsRepository.findAll();
    }

    @Override
    public List<Car> getCarDetails() {
        return this.carsRepository.findAll();
    }

}