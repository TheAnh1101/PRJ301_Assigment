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
import model.Student;

/**
 *
 * @author AD
 */
public class UserDBContext extends DBContext<User> {

    public User getUserByUsernamePasswordLecturer(String username, String password) {
        PreparedStatement stm = null;
        User user = null;
        try {
            String sql = "SELECT u.[uid], u.username, u.[password], u.displayname, u.email, l.lid,l.lname, l.dob, l.gender FROM [User] u\n"
                    + "INNER JOIN user_lecturer ul ON ul.[uid] = u.[uid] AND ul.active = 1\n"
                    + "INNER JOIN lecturer l ON ul.lid = l.lid\n"
                    + "WHERE U.username = ? AND U.[password] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setDisplayname(rs.getString("displayname"));
                user.setEmail(rs.getString("email"));
                int lid = rs.getInt("lid");
                if (lid != 0) {
                    Lecturer lecturer = new Lecturer();
                    lecturer.setId(lid);
                    lecturer.setName(rs.getString("lname"));
                    lecturer.setGender(rs.getBoolean("gender"));
                    lecturer.setDob(rs.getDate("dob"));
                    user.setLecturer(lecturer);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public User getUserByUsernamePasswordStudent(String username, String password) {
        PreparedStatement stm = null;
        User user = null;
        try {
            String sql = "SELECT u.[uid], u.username, u.[password], u.displayname,u.email, s.[sid],s.sname, s.dob, s.gender FROM [User] u\n"
                    + "INNER JOIN user_students us ON us.[uid] = u.[uid] AND us.active = 1\n"
                    + "INNER JOIN students s ON us.[sid] = s.[sid]\n"
                    + "WHERE U.username = ? AND U.[password] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setDisplayname(rs.getString("displayname"));
                user.setEmail(rs.getString("email"));
                int sid = rs.getInt("sid");
                if (sid != 0) {
                    Student student = new Student();
                    student.setId(sid);
                    student.setName(rs.getString("sname"));
                    student.setGender(rs.getBoolean("gender"));
                    student.setDob(rs.getDate("dob"));
                    user.setStudent(student);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public User getInforStudent(int id) {
        PreparedStatement stm = null;
        User user = null;
        try {
            String sql = "SELECT u.uid,u.username,u.displayname,s.sid,s.sname,u.email,s.dob,s.gender FROM [User] u \n"
                    + "INNER JOIN user_students us ON u.uid = us.uid\n"
                    + "INNER JOIN students s ON s.sid = us.sid \n"
                    + "WHERE s.sid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setDisplayname(rs.getString("displayname"));
                user.setEmail(rs.getString("email"));

                Student stu = new Student();
                stu.setId(rs.getInt("sid"));
                stu.setName(rs.getString("sname"));
                stu.setDob(rs.getDate("dob"));
                stu.setGender(rs.getBoolean("gender"));
                user.setStudent(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public User getInforLecturer(int id) {
        PreparedStatement stm = null;
        User user = null;
        try {
            String sql = "SELECT u.uid,u.username,u.displayname,l.lid,l.lname,u.email,l.dob,l.gender FROM [User] u \n"
                    + "INNER JOIN user_lecturer ul ON u.uid = ul.uid\n"
                    + "INNER JOIN lecturer l ON l.lid = ul.lid \n"
                    + "WHERE l.lid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setDisplayname(rs.getString("displayname"));
                user.setEmail(rs.getString("email"));
                
                Lecturer lec = new Lecturer();
                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                lec.setDob(rs.getDate("dob"));
                lec.setGender(rs.getBoolean("gender"));
                user.setLecturer(lec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
