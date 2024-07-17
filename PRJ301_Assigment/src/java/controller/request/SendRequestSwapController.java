/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.request;

import dal.CourseDBContext;
import dal.RequestDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.PageContext;
import java.util.ArrayList;
import model.Course;
import model.Student;
import model.SwapRequest;
import model.User;

/**
 *
 * @author AD
 */
public class SendRequestSwapController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendRequestSwapController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendRequestSwapController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.getStudent() != null) {
            int target_sid = Integer.parseInt(request.getParameter("sid"));
            int target_cid = Integer.parseInt(request.getParameter("cid"));

            StudentDBContext dbStu = new StudentDBContext();
            CourseDBContext dbCou1 = new CourseDBContext();
            CourseDBContext dbCou2 = new CourseDBContext();

            Student target_stu = dbStu.get(target_sid);
            ArrayList<Course> listCouOfCurrent = dbCou1.filterByStudentID(user.getId());
            ArrayList<Course> listCouOfTarget = dbCou2.filterByStudentID(target_sid);
//            Course target_cou = dbCou.get(target_cid);

            request.setAttribute("targetStu", target_stu);
            request.setAttribute("listCouCurrent", listCouOfCurrent);
            request.setAttribute("listCouTarget", listCouOfTarget);
//            request.setAttribute("targetCou", target_cou);
            request.getRequestDispatcher("../view/swap/send.jsp").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sender_id = Integer.parseInt(request.getParameter("sender_id"));
        int fromclass_id = Integer.parseInt(request.getParameter("fromclass"));
        int receiver_id = Integer.parseInt(request.getParameter("receiver_id"));
        int toclass_id = Integer.parseInt(request.getParameter("toclass"));
        String mess = request.getParameter("mess");
        String status = "pending";
        
        SwapRequest req = new SwapRequest();
        req.setSender_id(sender_id);
        req.setReceiver_id(receiver_id);
        req.setCurrent_cid_sender(fromclass_id);
        req.setCurrent_cid_receiver(toclass_id);
        req.setStatus(status);
        req.setMess(mess);

        RequestDBContext db = new RequestDBContext();
        db.insert(req);
        
        response.sendRedirect(request.getContextPath() +"/list/request?sender_id="+req.getSender_id());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
