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
public class BinarySearch {
    
    // returns the position of the employee on the list
    public static int binarySearch(ArrayList<Employee> list, int low, int high, String target) {

        // returns -1 if the name can't be found on the list
        if (low > high) {
            
            return -1;
            
        }

        // find the middle position
        int mid = low + (high - low) / 2;

        // checks if the name searched is the middle one, if it comes before or after it
        int result = target.compareToIgnoreCase(list.get(mid).getFullName());

        if (result == 0) {
            
            return mid; // found
            
        } else if (result < 0) {
            
            // searched name comes before mid, so searches the left half
            return binarySearch(list, low, mid - 1, target);
            
        } else {
            
            // searched name comes after mid, so search the right half
            return binarySearch(list, mid + 1, high, target);
            
        }
    }        
}
