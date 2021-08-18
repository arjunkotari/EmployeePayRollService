package com.bridgelabz;

import java.util.Objects;

public class EmployeePayroll {
    public int id;
    public String name;
    public double salary;

    public EmployeePayroll(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayroll that = (EmployeePayroll) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }


    @Override
    public String toString()
    {
        return "id = "+id + " name = " + name + " salary = "+salary;
    }
}
