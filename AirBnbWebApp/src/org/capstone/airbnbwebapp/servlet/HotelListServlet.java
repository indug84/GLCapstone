package org.capstone.airbnbwebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.capstone.airbnbwebapp.beans.Hotel;
import org.capstone.airbnbwebapp.utils.DBUtils;
import org.capstone.airbnbwebapp.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/hotelList" })
public class HotelListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public HotelListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Hotel> list = null;
        try {
            list = DBUtils.queryHotel(conn);  
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("hotelList", list);
         
        // Forward to /WEB-INF/views/hotelListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/hotelListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
