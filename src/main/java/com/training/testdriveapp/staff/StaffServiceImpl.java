package com.training.testdriveapp.staff;

import com.training.testdriveapp.admin.Car;
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
 *          @author           Deepaa Umapathi
 *          Description      It is a service class that provides the services for adding a new staff,
updating fund and viewing all the accounts
 *         Version             1.0
 *         Created Date    02-APR-2020
 ************************************************************************************/

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
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
        return this.staffRepository.save(newStaff);
    }

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

    @Override
    public Optional<Staff> getByStaffId(Integer staffId) throws StaffException{
        Optional<Staff> foundStaff = this.staffRepository.findBystaffId(staffId);
        if(!foundStaff.isPresent())
            throw new StaffException("No such Id Exists: "+ staffId);
        return foundStaff;
    }

    @Override
    public Optional<Staff> deleteStaff(Integer staffId) throws  StaffException {
        Optional<Staff> foundStaff = this.staffRepository.findBystaffId(staffId);
        if(foundStaff.isPresent()) {
            this.staffRepository.deleteById(staffId);
        }
        return null;
    }

    @Override
    public List<Staff> getAllStaffs() throws StaffException {
        List<Staff> staffList = new ArrayList<>();
        staffList = this.staffRepository.findAll();
        if(staffList == null)
            throw new StaffException("No Product Exists");
        return staffList;
    }

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

