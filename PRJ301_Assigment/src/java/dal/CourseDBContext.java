/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Course;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;
import model.Semester;
import model.Student;
import model.Subject;

/**
 *
 * @author X1 Nano
 */
public class CourseDBContext extends DBContext<Course> {

    public ArrayList<Course> filterByLecturerID(int lid) {
        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT c.cid,c.cname,c.subid,sub.subname,c.lid,s.semid,s.season,s.active,s.year FROM \n"
                    + "courses c INNER JOIN semester s ON s.semid = c.semid\n"
                    + "INNER JOIN subjects sub ON sub.subid = c.subid\n"
                    + "WHERE s.active = 1 AND c.lid = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));

                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));
                c.setLecturer(l);

                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                c.setSubject(sub);

                Semester sem = new Semester();
                sem.setId(rs.getInt("semid"));
                c.setSemester(sem);

                courses.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return courses;
    }

    public ArrayList<Course> filterByStudentID(int sid) {
        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT c.cid,c.cname,c.subid,sub.subname,c.lid,sc.sid, s.semid,s.season,s.active,s.year FROM\n"
                    + "                    courses c INNER JOIN semester s ON s.semid = c.semid\n"
                    + "                    INNER JOIN subjects sub ON sub.subid = c.subid\n"
                    + "					INNER JOIN students_courses sc ON sc.cid = c.cid\n"
                    + "                    WHERE s.active = 1 AND sc.sid =  ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));

                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));
                c.setLecturer(l);

                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                c.setSubject(sub);

                Semester sem = new Semester();
                sem.setId(rs.getInt("semid"));
                c.setSemester(sem);

                courses.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return courses;
    }

    @Override
    public ArrayList<Course> all() {
        PreparedStatement stm = null;
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Courses";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));

                Semester s = new Semester();
                s.setId(rs.getInt("semid"));

                Subject su = new Subject();
                su.setId(rs.getInt("subid"));

                Course course = new Course();
                course.setId(rs.getInt("cid"));
                course.setName(rs.getString("cname"));
                course.setLecturer(l);
                course.setSemester(s);
                course.setSubject(su);

                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return courses;

    }

    @Override
    public Course get(int cid) {
        PreparedStatement stm = null;
        Course course = null;
        try {
            String sql = "SELECT c.cid, c.cname, l.lid, l.lname,se.semid, se.season,se.[year],sub.subid,sub.subname  FROM courses c \n"
                    + "INNER JOIN lecturer l ON c.lid =l.lid\n"
                    + "INNER JOIN semester se ON se.semid = c.semid\n"
                    + "INNER JOIN subjects sub ON sub.subid = c.subid\n"
                    + "WHERE c.cid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {                
                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));

                Semester sem = new Semester();
                sem.setId(rs.getInt("semid"));
                sem.setSeason(rs.getString("season"));
                sem.setYear(rs.getString("year"));

                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));

                course = new Course();
                course.setId(rs.getInt("cid"));
                course.setName(rs.getString("cname"));
                course.setLecturer(l);
                course.setSemester(sem);
                course.setSubject(sub);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return course;
    }
    @Override
    public void insert(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
