package Product;

import DBUtils.DBUtils;
import User.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Thắng
 */
public class DAO {

    private static final String SEARCH = "SELECT product_id, product_code, title, quantity, price, discount_price,"
            + " weight, thumbnail, description, create_at, update_at, status, category_id  FROM tbl_Product WHERE title like ?";
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement stm = null;

    public List<DTO> getProducts() {
        List<DTO> list = new ArrayList<>();

        try {
            cn = (Connection) DBUtils.getConnection();
            String sql = "select * from tbl_Product";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DTO p = new DTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13));
                list.add(p);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<DTO> getProductByCategory(String category_id) {
        List<DTO> list = new ArrayList<>();

        try {
            cn = (Connection) DBUtils.getConnection();
            String sql = "select * from tbl_Product where category_id = ?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, category_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DTO p = new DTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(String product_id) {

        try {
            cn = (Connection) DBUtils.getConnection();
            String sql = "delete from tbl_Product where product_id= ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, product_id);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void updateProduct(String title, String quantity, int price, int discount_price,
//            Float weight, String thumbnail, String description,
//            Date create_at, Date update_at, boolean status, int category_id) {
//        try {
//            cn = (Connection) DBUtils.getConnection();
//            String sql = "update tbl_Product\n"
//                    + "Set title = ?, quantity = ?, price= ?, discount_price = ?, wieght = ?, thumbnail= ?, description = ?,\n"
//                    + "create_at= ?, update_at = ?, status = ?, category_id = ?\n"
//                    + "where product_id = ?";
//            if (cn != null) {
//                stm = cn.prepareStatement(sql);
//                stm.setString(1, title);
//                stm.setString(2, quantity);
//                stm.setInt(3, price);
//                stm.setInt(4, discount_price);
//                stm.setFloat(5, weight);
//                stm.setString(6, thumbnail);
//                stm.setString(7, description);
//                stm.setDate(8, (java.sql.Date) create_at);
//                stm.setDate(9, (java.sql.Date) update_at);
//                stm.setBoolean(10, status);
//                stm.setInt(11, category_id);
//
//                stm.executeUpdate();
//            }
//        } catch (Exception e) {
//        }
//    }
    public void updateProduct(String title, String quantity, String price, String discount_price, String weight,
            String thumbnail, String description, String create_at, String update_at, String status,
            String category_id, String product_id) {
        String sql = "update tbl_Product\n"
                + "Set [title] = ?, [quantity] = ?, [price]= ?, [discount_price] = ?, [weight] = ?, [thumbnail]= ?, [description] = ?,\n"
                + "[create_at]= ?, [update_at] = ?, [status] = ?, [category_id] = ?\n"
                + "where [product_id] = ?";
        try {
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, quantity);
            stm.setString(3, price);
            stm.setString(4, discount_price);
            stm.setString(5, weight);
            stm.setString(6, thumbnail);
            stm.setString(7, description);
            stm.setString(8, create_at);
            stm.setString(9, update_at);
            stm.setString(10, status);
            stm.setString(11, category_id);
            stm.setString(12, product_id);
            stm.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        }

    }

    public DTO getProductById(String product_id) {
//        String sql = "select * from tbl_Product where product_id=?";
        try {
            String sql = "select * from tbl_Product where product_id=?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, product_id);
            rs = stm.executeQuery();
            if (rs.next()) {
                DTO p = new DTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13));
                return p;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public DTO getProductById(int product_id) {
//        String sql = "select * from tbl_Product where product_id=?";
        try {
            String sql = "select * from tbl_Product where product_id=?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setInt(1, product_id);
            rs = stm.executeQuery();
            if (rs.next()) {
                DTO p = new DTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13));
                return p;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void InsertProduct(String title, String quantity, String price, String discount_price, String weight,
            String thumbnail, String description, String create_at, String update_at, String status,
            String category_id) {
        String sql = "INSERT INTO [dbo].[tbl_Product] " +
                "([title], [quantity], [price], [discount_price], [weight], " +
                "[thumbnail], [description], [create_at], [update_at], " +
                "[status], [category_id]) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, quantity);
            stm.setString(3, price);
            stm.setString(4, discount_price);
            stm.setString(5, weight);
            stm.setString(6, thumbnail);
            stm.setString(7, description);
            stm.setString(8, create_at);
            stm.setString(9, update_at);
            stm.setString(10, status);
            stm.setString(11, category_id);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DAO dao = new DAO();

//        DTO s = dao.getProductById("1");
//        System.out.println(s);
        DTO list = dao.getProductById(1);
//        for (DTO productDTO : list) {
//            System.out.println(productDTO);
//        }
System.out.println(list);
    }

    public void update(DTO edittedItem) throws Exception {

        try {
            String sql;
            sql = "update tbl_Product\n"
                    + "Set [title] = ?, [quantity] = ?, [price]= ?, [discount_price] = ?, [weight] = ?, [thumbnail]= ?, [description] = ?,\n"
                    + "[create_at]= ?, [update_at] = ?, [status] = ?, [category_id] = ?\n"
                    + "where [product_id] = ?";

            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, edittedItem.getTitle());
            stm.setInt(2, edittedItem.getQuantity());
            stm.setInt(3, edittedItem.getPrice());
            stm.setInt(4, edittedItem.getDiscount_price());
            stm.setFloat(5, edittedItem.getWeight());
            stm.setString(6, edittedItem.getThumbnail());
            stm.setString(7, edittedItem.getDescription());
            stm.setDate(8, (java.sql.Date) edittedItem.getCreate_at());
            stm.setDate(9, (java.sql.Date) edittedItem.getUpdate_at());
            stm.setBoolean(10, edittedItem.isStatus());
            stm.setInt(11, edittedItem.getCategory_id());
            stm.setInt(12, edittedItem.getProduct_id());
            stm.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List<DTO> getlistProducts(String search) throws SQLException {
        List<DTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int product_id = rs.getInt("product_id");
                    String product_code = rs.getString("product_code");
                    String title = rs.getString("title");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    int discount_price = rs.getInt("discount_price");
                    float weight = rs.getFloat("weight");
                    String thumbnail = rs.getString("thumbnail");
                    String description = rs.getString("description");
                    java.sql.Date create_at = rs.getDate("create_at");
                    java.sql.Date update_at = rs.getDate("update_at");
                    boolean status = rs.getBoolean("status");
                    int category_id = rs.getInt("category_id");

                    list.add(new DTO(product_id, product_code, title, quantity, price, discount_price, weight, thumbnail, description, create_at, update_at, status, category_id));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (rs != null) {
                rs.close();
            }

            if (ptm != null) {
                ptm.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return list;
    }

    public boolean checkout(int quantity, int product_id) throws Exception {
        boolean check = false;
        try {
            String sql;
            sql = "Update tbl_Product set quantity= quantity - ? Where product_id = ?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, product_id);
            check = stm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
        }
        return check;
    }
}
