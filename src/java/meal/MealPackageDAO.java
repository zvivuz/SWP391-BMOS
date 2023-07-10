/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meal;

import DBUtils.DBUtils;
import Product.DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
