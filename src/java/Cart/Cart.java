/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cart;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import meal.MealPackageDTO;

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

    public CartItem getItemById(int id) {
        for (CartItem i : listCartItem) {
            if (i.getProduct() != null && i.getProduct().getProduct_id() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public void addItem(CartItem t) {
        if (getItemById(t.getProduct().getProduct_id()) != null) {
            CartItem i = getItemById(t.getProduct().getProduct_id());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            listCartItem.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            listCartItem.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (CartItem i : listCartItem) {
            t += i.getQuantity() * i.getPrice();
        }
        return t;
    }

    public CartItem getPackageItemById(int id) {
        for (CartItem i : listCartItem) {
            if (i.getMealPackage() != null && i.getMealPackage().getMeal_package_id() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityByPackageId(int id) {
        return getPackageItemById(id).getQuantity();
    }

    public void addPackageItem(CartItem t) {
        if (getPackageItemById(t.getMealPackage().getMeal_package_id()) != null) {
            CartItem i = getPackageItemById(t.getMealPackage().getMeal_package_id());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            listCartItem.add(t);
        }
    }
    
     public void removePackageItem(int id) {
        if (getPackageItemById(id) != null) {
            listCartItem.remove(getPackageItemById(id));
        }
    }

}