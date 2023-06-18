/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cart;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Cart {
     private List<CartItem> listCartItem;

    public Cart() {
        listCartItem = new ArrayList<CartItem>();
    }

    public Cart(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }

    public List<CartItem> getListCartItem() {
        return listCartItem;
    }

    public void setListCartItem(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }

    public boolean containsKey(String pid) {
        boolean check = false;
        for (CartItem cartItem : listCartItem) {
            if (cartItem.getProduct().getProduct_id().equals(pid)) {
                cartItem.setAmount(cartItem.getAmount() + 1);
                check = true;
            }
        }
        return check;
    }

    
}
