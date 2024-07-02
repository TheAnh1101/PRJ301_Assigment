/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;

/**
 *
 * @author AD
 */
public class UserDBContext extends DBContext<User> {
    
    public User getUserByUsernamePassword(String username, String password) {
        PreparedStatement stm = null;
        User user = null;
        try {
            String sql = "SELECT u.[uid], u.username, u.[password], u.displayname, l.lid,l.lname, l.email, l.dob, l.gender FROM [User] u\n"
                    + "LEFT JOIN user_lecturer ul ON ul.[uid] = u.[uid] AND ul.active = 1\n"
                    + "LEFT JOIN lecturer l ON ul.lid = l.lid\n"
                    + "WHERE u.username =? AND u.[password] = ? ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setDisplayname(rs.getNString("displayname"));
                int lid = rs.getInt("lid");
                if (lid != 0) 
                {
                    Lecturer lecturer = new Lecturer();
                    lecturer.setId(lid);
                    lecturer.setName(rs.getString("lname"));
                    lecturer.setGender(rs.getBoolean("gender"));
                    lecturer.setEmail(rs.getString("email"));
                    lecturer.setDob(rs.getDate("dob"));
                    user.setLecturer(lecturer);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }
    
    @Override
    public ArrayList<User> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void insert(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
