/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cart;

import Product.DTO;

/**
 *
 * @author HP
 */
public class CartItem {
     private DTO product;
    private int amount;

    public CartItem() {
    }

    public CartItem(DTO product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public DTO getProduct() {
        return product;
    }

    public void setProduct(DTO product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
