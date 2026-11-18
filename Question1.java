/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Question1 {

  public class SalesReport { 

 

    private static final int NUMBER_OF_MONTHS = 3; 

 

    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in);   
         String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
           int[][] monthlySales = new int[productNames.length][NUMBER_OF_MONTHS];
                                                                                         
              for (int product = 0; product < productNames.length; product++) { 
                                                                                                                                                          
            for (int month = 0; month < NUMBER_OF_MONTHS; month++) { 

                System.out.print("Enter number of sales for month " + (month + 1)+ " for " + productNames[product] + " mattress: "); 
                     monthlySales[product][month] = input.nextInt();
            }
            System.out.println();
              }
              
       Product products = new Product(productNames, monthlySales); 
       PrintProduct printer = new PrintProduct(products);
       
       System.out.println("Product sale report");
        printer.printTotalProductSales(); 
        printer.printAverageProductSales(); 
        printer.printMostPopularProduct(); 

        input.close(); 

    } 
}