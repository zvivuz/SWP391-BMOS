/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meal;

import Blog.BlogDTO;
import DBUtils.DBUtils;
import Product.DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 09047
 */
public class MealPackageDAO {

    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement stm = null;

    public List<MealPackageDTO> getMealPackages() {
        List<MealPackageDTO> list = new ArrayList<>();
        try {
            cn = (Connection) DBUtils.getConnection();
            String sql = "select * from tbl_MealPackage";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                MealPackageDTO mp = new MealPackageDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getString(15));
                list.add(mp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        MealPackageDAO dao = new MealPackageDAO();
        List<MealPackageDTO> dto = dao.getMealPackages();
        System.out.println(dto);
//        BlogDAO dao = new BlogDAO();
//        List<BlogDTO> dto = dao.getBlog();
//        System.out.println(dto);
//    DTO s =  dao.getProductById("1");
//        System.out.println(s);
//        List<BlogDTO> list = dao.getBlogByName("ào");
//        for (BlogDTO productDTO : list) {
//            System.out.println(productDTO);
//        }
//        System.out.println(dao.getBlogtById("4"));
    }

    public MealPackageDTO getMealPackageById(String package_id) {
        try {
            String sql = "select * from tbl_MealPackage where meal_package_id=?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, package_id);
            rs = stm.executeQuery();
            if (rs.next()) {
                MealPackageDTO mp = new MealPackageDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getBoolean(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getString(15));
                return mp;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkoutMealPackage(int quantity, int meal_package_id) throws Exception {
        boolean check = false;
        try {
            String sql;
            sql = "update tbl_MealPackage\n"
                    + "set quantity = quantity - ? \n"
                    + "where meal_package_id = ?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, meal_package_id);
            check = stm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
        }
        return check;
    }

    public String getLastIdMealPackage() {
        try {
            String sql = "select top 1 meal_package_id\n"
                    + "from dbo.tbl_MealPackage\n"
                    + "order by meal_package_id desc";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);

            rs = stm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("meal_package_id");
                return id;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<DTO> getProductInsideMealPackage(String package_id) {
        List<DTO> list = new ArrayList<>();
        try {
            String sql = "SELECT tbl_Product.title\n"
                    + "FROM tbl_Meal\n"
                    + "JOIN tbl_MealPackage ON tbl_Meal.meal_package_id = tbl_MealPackage.meal_package_id\n"
                    + "JOIN tbl_Product ON tbl_Meal.product_id = tbl_Product.product_id\n"
                    + "where tbl_MealPackage.meal_package_id = ?";
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, package_id);
            rs = stm.executeQuery();
            while (rs.next()) {
                DTO p = new DTO(rs.getString(1));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public static void main(String[] args) {
//        MealPackageDAO dao = new MealPackageDAO();
////        List<MealPackageDTO> listM = dao.getMealPackages();
////        for (MealPackageDTO mealDTO : listM) {
////            System.out.println(mealDTO);
////        }
////        MealPackageDTO a = dao.getMealPackageById("1");
////        System.out.println(a);
//        
//        List<DTO> list = dao.getProductInsideMealPackage("1");
//        for (DTO dto : list) {
//            System.out.println(dto);
//        }
//    }
    public List<MealPackageDTO> getListByPage(List<MealPackageDTO> list, int start, int end) {
        ArrayList<MealPackageDTO> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void createMealPackage(String meal_code, String quantity,
            String price, String discount_price, String thumbnail, String bird_id,
            String title_mealpackage, String description, String recipe, String create_at,
            String update_at, String status, String lifecycle_id, String img) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[tbl_MealPackage] ( meal_code, title_mealpackage, quantity, price, discount_price, thumbnail, description, recipe,  create_at, update_at, status, bird_id, lifecycle_id, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            cn = DBUtils.getConnection();
            if (cn != null) {
                cn = (Connection) DBUtils.getConnection();
                stm = cn.prepareStatement(sql);
                stm.setString(1, meal_code);
                stm.setString(2, title_mealpackage);
                stm.setString(3, quantity);
                stm.setString(4, price);
                stm.setString(5, discount_price);
                stm.setString(6, thumbnail);
                stm.setString(7, description);
                stm.setString(8, recipe);
                stm.setString(9, create_at);
                stm.setString(10, update_at);
                stm.setString(11, status);
                stm.setString(12, bird_id);
                stm.setString(13, lifecycle_id);
                stm.setString(14, img);

//                stmt.setString(10, "1");
                stm.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }

    }

    public void updateMealPackage(String meal_code, String title_mealpackage, String quantity, String price, String discount_price,
            String thumbnail, String description, String recipe, String create_at, String update_at, String status,
            String bird_id, String lifecycle_id, String img, String meal_package_id) {
        String sql = "update tbl_MealPackage\n"
                + "Set [meal_code] = ?, [title_mealpackage] = ?, [quantity]= ?, [price] = ?, [discount_price] = ?, [thumbnail]= ?, [description] = ?, [recipe] =?,\n"
                + "[create_at]= ?, [update_at] = ?, [status] = ?,[bird_id] = ?,[lifecycle_id] = ?, [img] = ?\n"
                + "where [meal_package_id] = ?";
        try {
            cn = (Connection) DBUtils.getConnection();
            stm = cn.prepareStatement(sql);
            stm.setString(1, meal_code);
            stm.setString(2, title_mealpackage);
            stm.setString(3, quantity);
            stm.setString(4, price);
            stm.setString(5, discount_price);
            stm.setString(6, thumbnail);
            stm.setString(7, description);
            stm.setString(8, recipe);
            stm.setString(9, create_at);
            stm.setString(10, update_at);
            stm.setString(11, status);
            stm.setString(12, bird_id);
            stm.setString(13, lifecycle_id);
            stm.setString(14, img);
            stm.setString(15, meal_package_id);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
