/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2.bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
// reads the employee from the .txt file and keeps it into a list
public class EmployeeList {

    private ArrayList<Employee> employees = new ArrayList<>();

    // reads the file and adds it to the list
    public boolean fileReader(String fileName) {
        
        try {
            
            BufferedReader myReader = new BufferedReader(new FileReader(fileName));

            myReader.readLine(); // first line is the header, so it is skipped
            String line = myReader.readLine();

            while (line != null) {
                
                // ignores the empty lines at the end of the file
                if (!line.trim().isEmpty()) {
                    
                    String[] parts = line.split(",");
                    
                    // columns: 0 = first name, 1 = last name, 5 = department, 7 = job title
                    Employee employee = new Employee(parts[0].trim(), parts[1].trim(), parts[7].trim(), parts[5].trim());
                    employees.add(employee);
                    
                }
                
                line = myReader.readLine();
            }

            myReader.close();
            return true;
        
        // catches for file reading mistakrs
        } catch (FileNotFoundException e) {
            
            return false;
            
        } catch (IOException e) {
            
            return false;
            
        }
    }

    public ArrayList<Employee> getEmployees() {
        
        return employees;
        
    }
}