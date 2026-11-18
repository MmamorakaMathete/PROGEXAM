/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.question1;

/**
 *
 * @author Student
 */
public class PrintProduct {
 
 private final IProduct product; 

 

    public PrintProduct(IProduct product) { 

        this.product = product; 
    }
     
      public void printTotalProductSales() { 
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold()); 
    } 


    public void printAverageProductSales() { 
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold()); 
    }
    
       public void printMostPopularProduct() { 
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()); 
    }
}

    