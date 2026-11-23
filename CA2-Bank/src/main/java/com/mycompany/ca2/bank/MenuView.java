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
        
        System.out.println("\nSort or Search?");
        int i = 1;
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(i + ". " + option);
            i++;
            
        }
        
    }

    // gets the user output and returns -1 if not a number (avoid crashing)
    public int getChoice() {
        
        System.out.print("Choose between 1-5.");
        String input = myKB.nextLine();
        
        try {
            
            return Integer.parseInt(input);
            
        } catch (NumberFormatException e) {
            
            return -1;
            
        }
        
    }

    public void showMessage(String message) {
        
        System.out.println(message);
        
    }
}