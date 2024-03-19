package com.training.testdriveapp.staffTest;

import com.training.testdriveapp.booking.BookIdDto;
import com.training.testdriveapp.booking.BookingException;
import com.training.testdriveapp.booking.BookingInputDto;
import com.training.testdriveapp.booking.BookingOutputDto;
import com.training.testdriveapp.staff.Staff;
import com.training.testdriveapp.staff.StaffException;
import com.training.testdriveapp.staff.StaffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class StaffTestCases {


    @Autowired
    private StaffService staffService;
    @Test
    public void addNewStaff() throws StaffException {
        String staffEmail;
        try {
            Staff staff = this.staffService.addNewStaff(new Staff("Deepaa","9876543210","deepaa@gmail.com"));
            staffEmail=staff.getStaffEmail();
            Assertions.assertNotNull(staff);
        } catch (StaffException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void nullStaffTestInaddNewStaffTest()
    {
        Assertions.assertThrows(StaffException.class,()->staffService.addNewStaff(null));
    }
    @Test
    void nulladdNewStaffTestExceptionMessageInNewStaffTest()
    {
        try {
            staffService.addNewStaff(null);
        } catch (StaffException e) {
            Assertions.assertEquals("Staff id can't be null",e.getMessage());
        }
    }
    @Test
    void noStaffTestExceptionMessageInNewStaffTest(){
        try {
            this.staffService.addNewStaff((new Staff("Deepaa","9876543210","deepaa@gmail.com")));
        } catch (StaffException e) {
            Assertions.assertEquals("No such Staff Exists", e.getMessage());
        }
    }
    @Test
    void deleteStaffTest()
    {
        try{
            this.staffService.deleteStaff(653);
        }
        catch (StaffException e)
        {
            Assertions.fail(e.getMessage());
        }
    }
    @Test
    void nullDeleteStaffTestInDeleteStaffByStaffId()
    {
        Assertions.assertThrows(StaffException.class,()->staffService.deleteStaff(null));
    }
    @Test
    void deleteStaffByStaffIdNoSuchStaffIdExists()
    {
        try {
            this.staffService.deleteStaff(-98);
        } catch (StaffException e) {
            Assertions.assertEquals("No such Staff Id exists",e.getMessage());
        }
    }

    @Test
    public void updateStaffTest()
    {
        try {
            Assertions.assertNotNull(staffService.updateStaffDetails(new Staff("Deepaa","9876543210","deepaa@gmail.com")));
        } catch (StaffException e) {
            e.printStackTrace();
        }
    }
//
//    //-ve testcase
    @Test
    public void nullStaffTestInUpdateStaff()
    {
        Assertions.assertThrows(StaffException.class,()->staffService.updateStaffDetails(null));
    }

    @Test
    void nullStaffTestExceptionMessageInUpdateStaff()
    {
        try {
            staffService.updateStaffDetails(null);
        } catch (StaffException e) {
            Assertions.assertEquals("Staff can't be null",e.getMessage());
        }
    }
//
    @Test
    void updateStaffNoSuchStaffExists()
    {
        try {
            this.staffService.updateStaffDetails(new Staff("Deepaa","987654321","deepaa@gmail.com"));
        } catch (StaffException e) {
            Assertions.assertEquals("No such Id Exists: 80",e.getMessage());
        }
    }
    @Test
    void nullStaffTestExceptionMessageInDeleteStaffByID()
    {
        try {
            this.staffService.deleteStaff(null);
        } catch (StaffException e) {
            Assertions.assertEquals("ID can't be null",e.getMessage());
        }
    }
    @Test
    void deleteStaffByIDNoSuchStaffExists()
    {
        try {
            this.staffService.deleteStaff(79);
        } catch (StaffException e) {
            Assertions.assertEquals("No such Id Exists: 79",e.getMessage());
        }
    }
//
//    //+ve testcase
    @Test
    void getAllStaffsTest()
    {
        try {
            this.staffService.getAllStaffs();
        } catch (StaffException e) {
            e.printStackTrace();
        }
    }
    //-ve testcase
    @Test
    void noStaffExistTestInGetAllStaffs()
    {
        try {
            this.staffService.getAllStaffs();
        } catch (StaffException e) {
            Assertions.assertEquals("No Staff Exists",e.getMessage());
        }
    }
//
//
//


}
