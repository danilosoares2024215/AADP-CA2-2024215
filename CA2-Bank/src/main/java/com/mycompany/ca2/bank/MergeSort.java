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
public class MergeSort {
    
    // splits the list in two parts, sorts each of them and merges them back again
    public static void mergeSort(ArrayList<Employee> list, int left, int right) {
        
        if (left < right) {
            
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
            
        }
    }

    // puts together both sorted halves back into the list in alphabetical order
    public static void merge(ArrayList<Employee> list, int left, int mid, int right) {
        
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];

        for (int i = 0; i < n1; i++)
            L[i] = list.get(left + i);
        
        for (int j = 0; j < n2; j++)
            R[j] = list.get(mid + 1 + j);
        

        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            
            // <= 0 keeps not changed names in their original order
            if (L[i].getFullName().compareToIgnoreCase(R[j].getFullName()) <= 0) {
                
                list.set(k, L[i]);
                i++;
                
            } else {
                
                list.set(k, R[j]);
                j++;
                
            }
            
            k++;
        }

        while (i < n1) {
            
            list.set(k, L[i]);
            i++;
            k++;
            
        }
        while (j < n2) {
            
            list.set(k, R[j]);
            j++;
            k++;
            
        }
    }
}    