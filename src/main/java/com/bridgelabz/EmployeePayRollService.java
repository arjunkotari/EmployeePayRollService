package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
    public enum IOService {CONSOLE_IO, FILE_TO,DB_IO, REST_IO}
    private List<EmployeePayrollData> employeePayRollList;

    public EmployeePayRollService(){}
    public EmployeePayRollService(List<EmployeePayrollData> employeePayRollList){
        this.employeePayRollList = employeePayRollList;
    }
    private void readEmployeePayRollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayRollList.add(new EmployeePayrollData(id, name, salary));
    }
    public void writeEmployeePayRollData(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writing Employee Payroll to Console "+employeePayRollList);
        else if(ioService.equals(IOService.FILE_TO))
            new EmployeePayrollFileIOService().writeData(employeePayRollList);
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayRollList = new ArrayList<EmployeePayrollData>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayRollData(IOService.CONSOLE_IO);
    }
}
