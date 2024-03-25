package com.training.testdriveapp.staff;

import com.training.testdriveapp.customer.Customer;
import com.training.testdriveapp.customer.CustomerException;
import com.training.testdriveapp.customer.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("http://localhost:4200/")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("staff")
    public Staff addNewStaff(@RequestBody Staff newStaff) throws StaffException
    {
        return this.staffService.addNewStaff(newStaff);
    }

    @PutMapping("Staff/update")
    public Staff updateAccount(@RequestBody Staff staff) throws StaffException {
        return this.staffService.updateStaffDetails(staff);
    }

    @GetMapping("GetStaffbyId/{staffid}")
    public Optional<Staff> getByStaffId(@PathVariable("staffid") Integer staffid) throws StaffException {
        return this.staffService.getByStaffId(staffid);
    }
    @DeleteMapping("staff/delete/{staffid}")
    public Optional<Staff> deleteAccountById(@PathVariable Integer staffid) throws StaffException {

        return this.staffService.deleteStaff(staffid);
    }
    @GetMapping("getAllStaffs")
    public List<Staff> getAllAccounts() throws StaffException {
        return this.staffService.getAllStaffs();
    }
    @GetMapping("getStaffbyEmail/{staffEmail}")
    public Optional<Staff> getByStaffEmail(@PathVariable("staffEmail") String staffEmail) throws StaffException {
        return Optional.ofNullable(this.staffService.getByStaffEmail(staffEmail));
    }
    @PostMapping("staff/login")
    public Staff login(@RequestBody StaffLoginDto staffLoginDto) throws StaffException {
        return this.staffService.login(staffLoginDto);
    }
}
