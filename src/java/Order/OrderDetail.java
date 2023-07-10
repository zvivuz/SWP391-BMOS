/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

/**
 *
 * @author Asus
 */
public class OrderDetail {
    private int orderDetail_id;
    private int price;
    private int quantity;
    private int product_id;
    private int order_id;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetail_id, int price, int quantity, int product_id, int order_id) {
        this.orderDetail_id = orderDetail_id;
        this.price = price;
        this.quantity = quantity;
        this.product_id = product_id;
        this.order_id = order_id;
    }

    public int getOrderDetail_id() {
        return orderDetail_id;
    }

    public void setOrderDetail_id(int orderDetail_id) {
        this.orderDetail_id = orderDetail_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    
    
}
