package com.training.testdriveapp.staff;

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
    public Staff addNewStaff(Staff newStaff) throws StaffException
    {
        return this.staffService.addNewStaff(newStaff);
    }

    @PutMapping("UpdateStaff")
    public Staff updateAccount(@RequestBody Staff staff) throws StaffException {
        return this.staffService.updateStaffDetails(staff);
    }

    @GetMapping("GetStaffbyId/{staffid}")
    public Optional<Staff> getByStaffId(@PathVariable("staffid") Integer staffid) throws StaffException {
        return this.staffService.getByStaffId(staffid);
    }
    @DeleteMapping("DeleteStaff/{staffid}")
    public Optional<Staff> deleteAccountById(@PathVariable Integer staffid) throws StaffException {

        return this.staffService.deleteStaff(staffid);
    }
    @GetMapping("getAllStaffs")
    public List<Staff> getAllAccounts() throws StaffException {
        return this.staffService.getAllStaffs();
    }
}
