/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.SwapRequest;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class RequestDBContext extends DBContext<SwapRequest> {
    public ArrayList<SwapRequest> getBySenderId(int id){
        PreparedStatement stm = null;
        ArrayList<SwapRequest> listRequest = new ArrayList<>();
        try {
            String sql = "SELECT * FROM class_swap_requests\n"
                    + "WHERE sender_sid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                SwapRequest sr = new SwapRequest();
                sr.setId(rs.getInt("request_id"));
                sr.setSender_id(rs.getInt("sender_id"));
                sr.setReceiver_id(rs.getInt("receiver_id"));
                sr.setCurrent_cid_sender(rs.getInt("current_cid_sender"));
                sr.setCurrent_cid_receiver(rs.getInt("current_cid_receiver"));
                sr.setStatus(rs.getString("status"));
                sr.setMess(rs.getString("mess"));
                listRequest.add(sr);
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
        return listRequest;
    
    }
    
    @Override
    public ArrayList<SwapRequest> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SwapRequest get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(SwapRequest model) {
        PreparedStatement stm = null;
        PreparedStatement stm_query = null;
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [class_swap_requests]\n"
                    + "           ([sender_sid]\n"
                    + "           ,[receiver_sid]\n"
                    + "           ,[current_cid_sender]\n"
                    + "           ,[current_cid_receiver]\n"
                    + "           ,[status]\n"
                    + "           ,[mess])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSender_id());
            stm.setInt(2, model.getReceiver_id());
            stm.setInt(3, model.getCurrent_cid_sender());
            stm.setInt(4, model.getCurrent_cid_receiver());
            stm.setString(5, model.getStatus());
            stm.setString(6, model.getMess());
            stm.executeUpdate();

            String sql_query = "SELECT @@IDENTITY as request_id";
            stm_query = connection.prepareStatement(sql_query);
            ResultSet rs = stm_query.executeQuery();
            if (rs.next()) {
                model.setId(rs.getInt("request_id"));
            }
            connection.commit();

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(SwapRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SwapRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
