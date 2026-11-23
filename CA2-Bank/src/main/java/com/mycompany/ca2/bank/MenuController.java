/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2.bank;

import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
// controlls the menu according to user inputs (MenuView)
public class MenuController {
    
private MenuView viewMenu = new MenuView();
private EmployeeList employeeList = new EmployeeList();

    public void run() {
        
        // program asks for the file name until the file is found and read
        boolean fileLoaded = false;
    
        while (!fileLoaded) {
            
            String fileName = viewMenu.getFileName();
            fileLoaded = employeeList.fileReader(fileName);

            if (fileLoaded) {
                
                viewMenu.showMessage("File was read successfully.");
                
            } else {
                
                viewMenu.showMessage("File wasn't found.");
                
            }
        }    
        
        MenuOptions[] options = MenuOptions.values();

        while (true) {
            
            viewMenu.showMenu();
            int choice = viewMenu.getChoice();

            // choice has to match the menu numbers (return -1 on MenuView)
            if (choice < 1 || choice > options.length) {
                
                viewMenu.showMessage("Invalid command. Please choose between the numbers on the menu. (1-5)");
                continue;
                
            }

            MenuOptions option = options[choice - 1];

            // messages displayed when user selects a menu option
            switch (option) {
                
                case SORT:
                    viewMenu.showMessage("Sort selected.");
                    ArrayList<Employee> employees = employeeList.getEmployees();
                    MergeSort.mergeSort(employees, 0, employees.size() - 1);
                    viewMenu.showFirstNames(employees, 20);
                    break;
                    
                case SEARCH:
                    
                    viewMenu.showMessage("Search selected.");
                    break;
                    
                case ADD_RECORDS:
                    
                    viewMenu.showMessage("Add record selected.");
                    break;
                    
                case CREATE_BINARY_TREE:
                    
                    viewMenu.showMessage("Binary Tree Creation selected.");
                    break;
                    
                case EXIT:
                    
                    viewMenu.showMessage("Closing program.");
                    return;
                    
            }
        }
    }
}