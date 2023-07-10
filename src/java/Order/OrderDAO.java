/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Cart.Cart;
import Cart.CartItem;
import DBUtils.DBUtils;
import User.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class OrderDAO {

    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement stm = null;

    public void addOrder(UserDTO u, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        int status= 1;
        try {
            cn = (Connection) DBUtils.getConnection();
            String sql = "insert into tbl_Order([order_date],[user_id],[totalMoney],[status]) values(?,?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, date);
            stm.setInt(2, u.getUserID());
            stm.setDouble(3, cart.getTotalMoney());
            stm.setInt(4,status );
            stm.executeUpdate();

            String sql1 = "select top 1 order_id from tbl_Order order by order_id desc";
            stm = cn.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (CartItem i : cart.getListCartItem()) {
                    String sql2 = "insert into tbl_OrderDetail([oder_id],[product_id],[quantity],[price]) values (?,?,?,?)";
                    stm = cn.prepareStatement(sql2);
                    stm.setInt(1, oid);
                    stm.setInt(2, i.getProduct().getProduct_id());
                    stm.setInt(3, i.getQuantity());
                    stm.setDouble(4, i.getPrice());
                    stm.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
