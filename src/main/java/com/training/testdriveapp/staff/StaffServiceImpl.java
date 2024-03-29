package com.training.testdriveapp.staff;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.admin.CarRepository;
import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerException;
import com.training.testdriveapp.customer.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
/************************************************************************************
 *          @author          Deepaa Umapathi
 *          Description      It is a service class that provides the services for adding a new staff,
updating staff ,deleting staff and viewing all the staffs
 *         Version             1.0
 *         Created Date    19-FEB-2024
 ************************************************************************************/

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private CarRepository carRepository;

    /************************************************************************************
     * Method: 			            -addNewStaff
     *Description: 			        -To add a new staff
     * @param newStaff              -Staff to be added

     * @returns Staff               - staff, if created otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff already exists or null
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/

    @Override
    public Staff addNewStaff(Staff newStaff) throws StaffException {
        if(newStaff==null){
            throw new StaffException("Staff can't be null");
        }
//        Optional<Staff> foundAccount = this.staffRepository.findBystaffId(newStaff.getStaffId());
//        if(foundAccount.isPresent())
//            throw new StaffException("Staff Already exists:"+newStaff.getStaffName());

        Optional<Staff> accountOpt=this.staffRepository.findBystaffEmail(newStaff.getStaffEmail());
        if(accountOpt.isPresent())
            throw new StaffException("Email already registered,please retry. "+newStaff.getStaffEmail());
        Staff staff = this.staffRepository.save(newStaff);
        String name = staff.getModelName();
        Car foundCar = this.carRepository.findByModelName(name);
        foundCar.setStaff(staff);
        this.carRepository.save(foundCar);
        return staff;

    }

    /************************************************************************************
     * Method: 			            -updateStaff
     *Description: 			        -To update a staff
     * @param staff                 -Staff to be updated

     * @returns Staff               - staff, if created otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff not exists
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Staff updateStaffDetails(Staff staff) throws StaffException {
            if(staff==null)
                throw new StaffException("Staff cannot be null");
            Optional<Staff> staffOpt=this.staffRepository.findByStaffEmail(staff.getStaffEmail());
            String staff2=staffOpt.get().getPhoneNumber();

            if(staff2==null) {
                throw new StaffException("Staff not exists with id "+staff.getStaffId());
            }
            staffOpt.get().setStaffEmail(staffOpt.get().getStaffEmail());
            staffOpt.get().setPhoneNumber(staff.getPhoneNumber());
            staffOpt.get().setStaffId(staffOpt.get().getStaffId());
            Staff staff1=staffOpt.get();

            return this.staffRepository.save(staff1);
    }


    /************************************************************************************
     * Method: 			            -getByStaffId
     *Description: 			        -To get a staff by id
     * @param  staffId              -Staff Id to get details

     * @returns Staff               - staff, if present otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff is  null
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/

    @Override
    public Optional<Staff> getByStaffId(Integer staffId) throws StaffException{
        Optional<Staff> foundStaff = this.staffRepository.findBystaffId(staffId);
        if(!foundStaff.isPresent())
            throw new StaffException("No such Id Exists: "+ staffId);
        return foundStaff;
    }

    /************************************************************************************
     * Method: 			            -deleteStaff
     *Description: 			        -To delete a staff
     * @param staffId               -Staff to be deleted


     * @throws StaffException       - It is raised due to if staff not exists or null
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Optional<Staff> deleteStaff(Integer staffId) throws  StaffException {
        Optional<Staff> foundStaff = this.staffRepository.findBystaffId(staffId);
        if(foundStaff.isPresent()) {
            this.staffRepository.deleteById(staffId);
        }
        return null;
    }

    /************************************************************************************
     * Method: 			            -getAllStaffs
     *Description: 			        -To get all staffs


     * @returns List                - list of staffs, if present otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff list is null
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/


    @Override
    public List<Staff> getAllStaffs() throws StaffException {
        List<Staff> staffList = new ArrayList<>();
        staffList = this.staffRepository.findAll();
        if(staffList == null)
            throw new StaffException("No Product Exists");
        return staffList;
    }
    /************************************************************************************
     * Method: 			            -getByStaffEmail
     *Description: 			        -To get a staff by Email id
     * @param  staffEmail           -Staff Email to get details

     * @returns Staff               - staff, if present otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff is  null
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/


    @Override
    public Staff getByStaffEmail(String staffEmail) throws StaffException {
        if(staffEmail==null){
            throw new StaffException("Staff doesn't exists with given id"+staffEmail);
        }
        Optional<Staff> staff=this.staffRepository.findByStaffEmail(staffEmail);
        if(!staff.isPresent()) {
            throw new StaffException("Staff doesn't exists");
        }
        Staff staff1=staff.get();
        return  staff1;
    }

    /************************************************************************************
     * Method: 			            -login
     *Description: 			        -To login staff
     * @param staffLoginDto         -staffLoginDto for getting staff emailId and password

     * @returns Staff               - staff, if logged  in successfully, otherwise throws StaffException
     * @throws StaffException       - It is raised due to if staff is not already exists and if the password does not match with emailId
    server side validation
     *Created By                    - Deepaa Umapathi
     *Created Date                  - 19-FEB-2024

     ************************************************************************************/

    @Override
    public Staff login(StaffLoginDto staffLoginDto) throws StaffException {
        Optional<Staff> staffOpt=this.staffRepository.findByStaffEmail(staffLoginDto.getStaffEmail());
        if(staffOpt.isEmpty()){
            throw  new StaffException("Staff does not exists");
        }
        Staff foundStaff=staffOpt.get();
        if(! staffOpt.get().getPhoneNumber().equals(staffLoginDto.getPhoneNumber()))
            throw new StaffException("Password is Incorrect");

        return foundStaff;
    }

}

