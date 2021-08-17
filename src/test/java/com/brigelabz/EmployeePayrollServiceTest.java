package com.brigelabz;

import com.bridgelabz.EmployeePayRollService;
import com.bridgelabz.EmployeePayroll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayroll[] arrayOfEmps = {
                new EmployeePayroll(1,"Jeff Bezos", 100000.0),
                new EmployeePayroll(2,"Bill Gates", 200000.0),
                new EmployeePayroll(3,"Mark Zuckerbarg", 300000.0)
        };
        EmployeePayRollService employeePayrollService;
        employeePayrollService = new EmployeePayRollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayRollData(EmployeePayRollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayRollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayRollService.IOService.FILE_IO);
        Assert.assertEquals(3,entries);
    }

    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
        EmployeePayRollService employeePayrollService = new EmployeePayRollService();
        long entries = employeePayrollService.readEmployeePayRollData(EmployeePayRollService.IOService.FILE_IO);
        Assert.assertEquals(3, entries);
    }

    @Test
    void givenDataInDB_WhenRetrieved_ShouldMatchTheCount() {
        EmployeePayRollService employeePayrollService = new EmployeePayRollService();
        List<EmployeePayroll> employeePayrolls = employeePayrollService.readEmployeePayrollData();
        Assertions.assertEquals(3, employeePayrolls.size());
    }
}
