/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question1;

/**
 *Ge
tAvera * @author Student
 */
public class Product {
    
      private final String[] productNames;
      private final int[][] monthlySales;
      
  public Product(String[] productNames, int[][] monthlySales) { 

        this.productNames = productNames; 

        this.monthlySales = monthlySales; 

    } 

  public int GetTotalProductsSold() { 

        int total = 0; 

        for (int product = 0; product < monthlySales.length; product++) {
          for (int month = 0; month < monthlySales[product].length; month++) { 

                total += monthlySales[product][month];}
          }
        return total;
  }
  
  public double GetAverageProductSold() { 

        int numberOfFigures = monthlySales.length * monthlySales[0].length; 

        return (double) GetTotalProductsSold() / numberOfFigures; 

    } 

    public String GetMostPopularProduct() { 

        int highestSale = 0; 
        int popularIndex = 0; 

 
        for (int product = 0; product < monthlySales.length; product++) { 
            for (int month = 0; month < monthlySales[product].length; month++) {
             
              if (monthlySales[product][month] > highestSale) { 

                    highestSale = monthlySales[product][month]; 

                    popularIndex = product; 

                } 

            } 

        } 

        return productNames[popularIndex] + "(" + highestSale + ")"; 

    } 

} 
           