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

    private static final String SEARCH = "SELECT product_id, title, quantity, price, discount_price,"
            + " wieght, thumbnail, description, create_at, update_at, status, category_id  FROM tbl_Product WHERE title like ?";
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
                DTO p = new DTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getDate(10),
                        rs.getBoolean(11),
                        rs.getInt(12));
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
                + "Set [title] = ?, [quantity] = ?, [price]= ?, [discount_price] = ?, [wieght] = ?, [thumbnail]= ?, [description] = ?,\n"
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
                DTO p = new DTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getDate(10),
                        rs.getBoolean(11),
                        rs.getInt(12));
                return p;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void InsertProduct(String title, String quantity, String price, String discount_price, String weight,
            String thumbnail, String description, String create_at, String update_at, String status,
            String category_id) {
        String sql = "insert into tbl_Product\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
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
        }

    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        DTO s = dao.getProductById("1");
        System.out.println(s);
//        List<DTO> list = dao.getProducts();
//        for (DTO productDTO : list) {
//            System.out.println(productDTO);
//        }

    }

    public void update(DTO edittedItem) throws Exception {

        try {
            String sql;
            sql = "update tbl_Product\n"
                    + "Set [title] = ?, [quantity] = ?, [price]= ?, [discount_price] = ?, [wieght] = ?, [thumbnail]= ?, [description] = ?,\n"
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
            stm.setString(12, edittedItem.getProduct_id());
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
                    String product_id = rs.getString("product_id");
                    String title = rs.getString("title");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    int discount_price = rs.getInt("discount_price");
                    float weight = rs.getFloat("wieght");
                    String thumbnail = rs.getString("thumbnail");
                    String description = rs.getString("description");
                    java.sql.Date create_at = rs.getDate("create_at");
                    java.sql.Date update_at = rs.getDate("update_at");
                    boolean status = rs.getBoolean("status");
                    int category_id = rs.getInt("category_id");

                    list.add(new DTO(product_id, title, quantity, price, discount_price, weight, thumbnail, description, create_at, update_at, true, category_id));
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

}
