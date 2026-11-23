/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2.bank;

import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MenuView {

private Scanner myKB = new Scanner(System.in);

    // menu output using enum
    public void showMenu() {
        
        System.out.println("\nSelect an option.");
        int i = 1;
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(i + ". " + option);
            i++;
            
        }
        
    }

    // gets the user output and returns -1 if not a number (avoid crashing)
    public int getChoice() {
        
        System.out.print("Choose between 1-5: ");
        String input = myKB.nextLine();
        
        try {
            
            return Integer.parseInt(input);
            
        } catch (NumberFormatException e) {
            
            return -1;
            
        }
        
    }
    
    // asks the user for the name of the file he wants to read
    public String getFileName() {
        
        System.out.print("Please enter the name of the file you want to open/read: ");        
        return myKB.nextLine();
        
    }    
    
    public void showMessage(String message) {
        
        System.out.println(message);
        
    }
}