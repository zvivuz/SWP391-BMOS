/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cart;

import Product.DTO;
import meal.MealPackageDTO;

/**
 *
 * @author HP
 */
public class CartItem {
    private MealPackageDTO mealPackage;
    private DTO product;
    private int quantity;
    private double price;
   

    public CartItem() {
    }

    public CartItem(DTO product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
      
    }
    
    public CartItem(MealPackageDTO mealPackage, int quantity, double price) {
        this.mealPackage = mealPackage;
        this.quantity = quantity;
        this.price = price;
      
    }

    public MealPackageDTO getMealPackage() {
        return mealPackage;
    }

    public void setMealPackage(MealPackageDTO mealPackage) {
        this.mealPackage = mealPackage;
    }
    

    public DTO getProduct() {
        return product;
    }

    public void setProduct(DTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

    
}