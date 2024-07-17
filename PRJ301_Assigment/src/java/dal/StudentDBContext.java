/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Student;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Lecturer;
import model.Semester;
import model.Subject;

/**
 *
 * @author sonnt-local
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> getStudentsByCourse(int cid) {
        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement stm = null;
        try {

            String sql = "SELECT s.sid,s.sname FROM students s INNER JOIN students_courses sc ON sc.sid = s.sid\n"
                    + "				INNER JOIN courses c ON c.cid = sc.cid\n"
                    + "				WHERE c.cid = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                students.add(s);
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
        return students;
    }

    public ArrayList<Student> getStudentByCid(int cid) {
        PreparedStatement stm = null;
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.sid, s.sname,s.gender, c.cid, c.cname, l.lid, l.lname,se.semid, se.season,se.[year],sub.subid,sub.subname FROM students s\n"
                    + "INNER JOIN students_courses sc ON s.sid = sc.sid\n"
                    + "INNER JOIN courses c ON sc.cid = c.cid\n"
                    + "INNER JOIN lecturer l ON c.lid =l.lid\n"
                    + "INNER JOIN semester se ON se.semid = c.semid\n"
                    + "INNER JOIN subjects sub ON sub.subid = c.subid\n"
                    + "WHERE c.cid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setGender(rs.getBoolean("gender"));

//                Lecturer l = new Lecturer();
//                l.setId(rs.getInt("lid"));
//                l.setName(rs.getString("lname"));
//
//                Semester sem = new Semester();
//                sem.setId(rs.getInt("semid"));
//                sem.setSeason(rs.getString("season"));
//                sem.setYear(rs.getString("year"));
//
//                Subject sub = new Subject();
//                sub.setId(rs.getInt("subid"));
//                sub.setName(rs.getString("subname"));
//
//                Course c = new Course();
//                c.setId(rs.getInt("cid"));
//                c.setName(rs.getString("cname"));
//                c.setLecturer(l);
//                c.setSemester(sem);
//                c.setSubject(sub);
                students.add(s);
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
        return students;
    }

    @Override
    public ArrayList<Student> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int sid) {
        PreparedStatement stm = null;
        Student s = null;
        try {
            String sql = "SELECT s.sid,s.sname, c.cid, c.cname FROM students s \n"
                    + "INNER JOIN students_courses sc ON sc.sid = s.sid\n"
                    + "INNER JOIN courses c ON c.cid = sc.cid\n"
                    + "WHERE s.sid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                
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
        return s;
    
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
