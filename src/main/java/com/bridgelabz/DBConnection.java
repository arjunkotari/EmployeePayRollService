package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBConnection {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "Sai1603";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        listDriver();

        Connection connection = null;
        try {
            System.out.println("Connecting to DataBase: "+jdbcurl);
            DriverManager.getConnection(jdbcurl,username,password);
            System.out.println("Connection to the database successfully: "+connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void listDriver(){
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while(drivers.hasMoreElements())
            System.out.println(drivers.nextElement());
    }
}
