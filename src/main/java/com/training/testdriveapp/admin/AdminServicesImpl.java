package com.training.testdriveapp.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***********************************************************************************************
 *          @author          Dhanya Lakshmi
 *          Description      It is a service class that provides the services for adding,
                             updating and deleting cars along with displaying them with filters
 *         Version           1.0
 *         Created Date      19-FEB-2024
 **********************************************************************************************/



@Service
public class AdminServicesImpl implements AdminServices {

    final CarRepository carsRepository;

    @Autowired
    public AdminServicesImpl(CarRepository carsRepository){
        this.carsRepository = carsRepository;
    }

    /************************************************************************************
     * Method: 			          - addNewCar
     *Description: 		          - To add a new car
     * @param newCars             - Car to be added

     * @returns Car               - car, if created otherwise throws AdminException
     * @throws AdminException     - It is raised due to if car already exists or null
                                    server side validation
     *Created By                  - Dhanya Lakshmi
     *Created Date                - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Car addNewCar(CarDto newCars) throws AdminException{
        if(newCars.getModelName() == null||newCars.getCompany() == null||newCars.getCarPrice()==null||newCars.getColor()==null||newCars.getMileage()==null||newCars.getRpm()==null||newCars.getSeater()==null||newCars.getFuelType()==null||newCars.getVehicleType()==null||newCars.getEngineModel()==null)
        {
            throw new AdminException("Car details cannot be null");
        }
        List<Car> findCar = getCarDetailsBymodelName(newCars.getModelName());
        Car car = new Car();
        if(findCar.isEmpty())
        {
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
            car.setImage(newCars.getImage());
            car.setDescription(newCars.getDescription());
        }
        else {
            throw new AdminException("Car already exist");
        }
        return this.carsRepository.save(car);

    }

    /************************************************************************************
     * Method: 			          - getCarDetailsBymodelName
     *Description: 		          - To get details of car using Model name
     * @param modelName           - Model name of the car used as a filter to get all
     *                              details of the car

     * @returns Car               - returns car if model name found
     *Created By                  - Dhanya Lakshmi
     *Created Date                - 19-FEB-2024

     ************************************************************************************/

    private List<Car> getCarDetailsBymodelName(String modelName) {
        return this.carsRepository.findBymodelName(modelName);
    }

    /***************************************************************************************
     * Method: 			          - getCarDetailsByModelName
     *Description: 		          - To get details of car using Model name
     * @param modelName           - Model name of the car used as a filter to get all
     *                              details of the car

     * @returns Car               - car, if created otherwise throws AdminException
     * @throws AdminException     - It is raised if model name is null or no such model name
                                    exist server side validation
     *Created By                  - Dhanya Lakshmi
     *Created Date                - 19-FEB-2024

     ***************************************************************************************/

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
    /**********************************************************************************
     * Method: 			          - updateCarDetails
     *Description: 		          - To update the details of the car
     * @param updateCar           - car to be updated

     * @returns Car               - car, if updated otherwise throws AdminException
     * @throws AdminException     - It is raised  if car id is not found or null
                                    server side validation
     *Created By                  - Dhanya Lakshmi
     *Created Date                - 19-FEB-2024

     **********************************************************************************/
    @Override
    public Car updateCarDetails(CarDto updateCar) throws AdminException {
        if(updateCar == null)
        {
            throw new AdminException("Null car details cannot be updated");
        }
        if(updateCar.getCarId()==null)
        {
            throw new AdminException("Car ID is mandatory to update the car");
        }
        Optional<Car> foundCarId = this.carsRepository.findById(updateCar.getCarId());
        if(foundCarId.isEmpty())
        {
            throw new AdminException("Car ID not found");
        }
        Car car = new Car();
        car.setCarId(updateCar.getCarId());
        car.setCarPrice(updateCar.getCarPrice());
        car.setColor(updateCar.getColor());
        car.setCompany(updateCar.getCompany());
        car.setEngineModel(updateCar.getEngineModel());
        car.setFuelType(updateCar.getFuelType());
        car.setModelName(updateCar.getModelName());
        car.setMileage(updateCar.getMileage());
        car.setRpm(updateCar.getRpm());
        car.setSeater(updateCar.getSeater());
        car.setVehicleType(updateCar.getVehicleType());
        car.setImage(updateCar.getImage());
        car.setDescription(updateCar.getDescription());
        return this.carsRepository.save(car);
    }

    @Override
    public Car deleteCarById(Integer carId) throws AdminException {
        Optional<Car> foundCar = this.carsRepository.findById(carId);
        if(carId==null)
            throw new AdminException("Car id cannot be null");
        if(foundCar.isPresent()) {
            this.carsRepository.deleteById(carId);
        }else{
            throw new AdminException("Car not found");
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

        return this.getCarDetails().stream().filter(s->s.getCarPrice()>=minprice&&s.getCarPrice()<=maxprice).toList();
    }

    @Override
    public List<Car> getCarDetails() {
        return this.carsRepository.findAll();
    }
}