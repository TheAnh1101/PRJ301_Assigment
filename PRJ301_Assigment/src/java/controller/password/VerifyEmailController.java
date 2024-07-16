/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.password;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import util.randomcode.RandomCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import util.sendmail.SendEmail;

/**
 *
 * @author AD
 */
public class VerifyEmailController extends HttpServlet {
  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("../view/auth/verifyEmail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String mess = "";

        UserDBContext db = new UserDBContext();
        User user = db.checkUsersForChangePass(email);
        if (user != null) {
            //Generate a new random code
            int code = RandomCode.randomCode(6);
            String newCode = String.valueOf(code);

            //Send Email
            String subject = "Code Reset Resquest";
            String content = "<h1>Code to change pasword</h1>"
                    + "<p>Your Code is: <strong>" + newCode + "</strong></p>";
            SendEmail.sendMail(email, subject, content);
            
            session.setAttribute("resetCode", code);
            session.setAttribute("userEmail", email);
            response.sendRedirect(request.getContextPath()+"/password/change");
        }else {
            mess = "Account not exist!!";
            request.setAttribute("message", mess);
            request.getRequestDispatcher("../view/auth/verifyEmail.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
