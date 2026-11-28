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
                    ArrayList<Employee> list = employeeList.getEmployees();
                    MergeSort.mergeSort(list, 0, list.size() - 1); // binarysearch only works on a sorted list, so it has to be sorted first

                    String name = viewMenu.getSearchName();
                    int position = BinarySearch.binarySearch(list, 0, list.size() - 1, name);

                if (position == -1) {
                    
                    viewMenu.showMessage("Employee coudn't be found.");
                
                } else {
                    
                    viewMenu.showEmployeeDetails(list.get(position));
        
                }
                    break;
                    
                case ADD_RECORDS:
                    
                    viewMenu.showMessage("Add record selected.");
                    
                    //asks for the person informations, adds the employee and shows the last added records
                    String firstName = askName("First name: ");
                    String lastName = askName("Last name: ");
                    String jobTitle = askOption("Job Title (select an option):", employeeList.getJobTitles());
                    String department = askOption("Department (select an option):", employeeList.getDepartments());

                    employeeList.addEmployee(new Employee(firstName, lastName, jobTitle, department));
                    viewMenu.showMessage("Employee added to the records");
                    viewMenu.showNewEmployees(employeeList.getNewEmployees());
                    
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
    
    // keep asking for user input until the user types something
    private String askName(String message) {
        
        String name = viewMenu.getText(message);
        
        while (name.isEmpty()) {
            
            viewMenu.showMessage("This field can't be empty.");            
            name = viewMenu.getText(message);
            
        }
        
        return name;
        
        }
    
    // keep askingfor user input until the user picks a number from the list given lists (Job Title and Departtment)
    private String askOption(String title, ArrayList<String> options) {
        
        int choice = viewMenu.getOptionChoice(title, options);
        
        while (choice < 1 || choice > options.size()) {
            
            viewMenu.showMessage("Please choose a number from the list.");
            choice = viewMenu.getOptionChoice(title, options);
            
        }
        
        return options.get(choice - 1);
        
        }
}