package com.training.testdriveapp.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/************************************************************************************
 *          @author          Ram Kumar
 *          Description      It is a service class that provides the services for adding anew account,
transferring fund and viewing all the accounts
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
            throw new StaffException("Staff id can't be null");
        }
        Optional<Staff> foundAccount = this.staffRepository.findBystaffId(newStaff.getStaffId());
        if(foundAccount.isPresent())
            throw new StaffException("Staff Already exists:"+newStaff.getStaffName());

        Optional<Staff> accountOpt=this.staffRepository.findBystaffEmail(newStaff.getStaffEmail());
        if(accountOpt.isPresent())
            throw new StaffException("Email already registered,please re try. "+newStaff.getStaffEmail());
        return this.staffRepository.save(newStaff);
    }

    @Override
    public Staff updateStaffDetails(Staff staff) throws StaffException {
        if(staff==null){
            throw new StaffException("Account can't be null");
        }
        return this.staffRepository.save(staff);
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
        if(!foundStaff.isPresent())
            throw new StaffException("No such Id Exists: "+ staffId);
        this.staffRepository.deleteBystaffId(staffId);
        return foundStaff;
    }

    @Override
    public List<Staff> getAllStaffs() throws StaffException {
        return this.staffRepository.findAll();

    }
}
