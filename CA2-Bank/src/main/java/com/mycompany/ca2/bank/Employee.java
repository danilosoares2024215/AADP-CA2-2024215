/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2.bank;

/**
 *
 * @author Danilo
 */

// represents employee read from the file or added by the user
public class Employee {
    
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String department;

    //contructor to create an employee with its variables
    public Employee(String firstName, String lastName, String managerType, String department) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = managerType;
        this.department = department;
        
    }

    //getters for employee
    public String getFirstName() {
        
        return firstName;
        
    }

    public String getLastName() {
        
        return lastName;
        
    }

    public String getManagerType() {
        
        return jobTitle;
        
    }

    public String getDepartment() {
        
        return department;
        
    }
}