package com.training.testdriveapp;

import com.training.testdriveapp.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StaffTestCases {
    @Autowired
    private StaffService staffService;
}
