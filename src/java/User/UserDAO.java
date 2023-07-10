package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DBUtils.DBUtils;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 09047
 */
public class UserDAO {

    public UserDTO checkLogin(String username, String password) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_User WHERE username=? AND password= ?";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    return new UserDTO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9));
                }
            }

        } catch (Exception e) {
        }
        return null;
    }
     public boolean updateProfile(UserDTO updateUser) throws SQLException {
        boolean checkUpdate = false;
        Connection cn = null;
        PreparedStatement stm = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                stm = cn.prepareStatement("UPDATE tbl_User SET  password = ?, fullname = ?, email = ?, phone_number = ?, address = ?  where user_id= ? ");      
                stm.setString(1, updateUser.getPassword());
                stm.setString(2, updateUser.getFullname());
                stm.setString(3, updateUser.getEmail());
                stm.setString(4, updateUser.getPhone());
                stm.setString(5, updateUser.getAddress());
                stm.setInt(6, updateUser.getUserID());
                checkUpdate = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return checkUpdate;

    }

    public static void main(String[] args) throws SQLException {
        UserDAO user = new UserDAO();
        user.checkLogin("admin", "1");
        System.out.println(user);
    }
}
