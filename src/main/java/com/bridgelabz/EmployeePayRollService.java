package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
    public enum IOService {CONSOLE, FILE_TO,REST_IO}
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
    private void writeEmployeePayRollData(){
        System.out.println("\n Writing Employee Payroll Roaster to Console\n"+ employeePayRollList);
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayRollList = new ArrayList<EmployeePayrollData>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayRollData();
    }
}
