/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.servlets;

import com.labppl.entities.Car;
import com.labppl.entities.Record;
import com.labppl.entities.User;
import com.labppl.hibernate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ehsan
 */
public class record extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            Record dbrecord = new Record();
            Session session = HibernateUtil.getSessionFactory().openSession();
            Car car = 
                    (Car)session.get(Car.class, Integer.parseInt(request.getParameter("carrb")));
            if(car.getQuantity() == 0){
                out.print("Sorry this car is not available!");
                out.print(
                        "<button type=\"button\" name=\"back\" "
                                + "onclick=\"history.back()\">Go Back</button>"
                );
                out.close();
                return;
            }
            dbrecord.setCarId(
            (Car)session.load(Car.class, Integer.parseInt(request.getParameter("carrb")))
            );
            dbrecord.setRentDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
            String hql = "FROM User U WHERE U.username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", request.getSession().getAttribute("username"));
            User user = ((User)query.list().get(0));
            dbrecord.setUsername(user);
            dbrecord.setType(
                request.getParameter("driver") == null ?"No Driver":"With Driver"
            );
            dbrecord.setStatus("Pending");
            car.setQuantity(car.getQuantity() - 1);
            session.beginTransaction();
            session.save(dbrecord);
            session.update(car);
            session.getTransaction().commit();
            session.close();
            response.sendRedirect("fetchRecords");
        } finally {
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
