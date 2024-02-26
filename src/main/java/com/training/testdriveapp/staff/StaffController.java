package com.training.testdriveapp.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("staff")
    public Staff addNewStaff(Staff newStaff) throws StaffException
    {
        return this.staffService.addNewStaff(newStaff);
    }

    @PutMapping("Update Staff")
    public Staff updateAccount(@RequestBody Staff staff) throws StaffException {
        return this.staffService.updateStaffDetails(staff);
    }

    @GetMapping("Get Staff by Id/{staffid}")
    public Optional<Staff> getByStaffId(@PathVariable("staffid") Integer staffid) throws StaffException {
        return this.staffService.getByStaffId(staffid);
    }
    @DeleteMapping("Delete Staff/{staffid}")
    public Optional<Staff> deleteAccountById(@PathVariable Integer staffid) throws StaffException {
        return this.staffService.deleteStaff(staffid);
    }
    @GetMapping("getAllStaffs")
    public List<Staff> getAllAccounts() throws StaffException {
        return this.staffService.getAllStaffs();
    }
}
