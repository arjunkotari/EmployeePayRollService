package com.brigelabz;

import com.bridgelabz.EmployeePayrollService;
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
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayRollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,entries);
    }

    @Test
    public void givenDataInDB_WhenRetrieved_ShouldMatchTheCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayroll> employeePayrolls = employeePayrollService.readEmployeePayrollData();
        Assertions.assertEquals(3, employeePayrolls.size());
    }

    @Test
    public void givenNewSalary_WhenUpdated_ShouldSyncInDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData();
        employeePayrollService.updateSalaryByName("TERISA", 4000000.00);
        boolean result = employeePayrollService.checkEmployeeDataSyncByName("TERISA");
        Assertions.assertTrue(result);
    }
}
