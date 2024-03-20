package com.training.testdriveapp.staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    Staff addNewStaff(Staff newStaff) throws StaffException;

    Staff updateStaffDetails(Staff staff) throws StaffException;

    Optional<Staff> getByStaffId(Integer staffId) throws StaffException;

    Optional<Staff> deleteStaff(Integer staffId) throws StaffException;

    List<Staff> getAllStaffs() throws StaffException;

}
