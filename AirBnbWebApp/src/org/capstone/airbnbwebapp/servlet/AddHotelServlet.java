package org.capstone.airbnbwebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.capstone.airbnbwebapp.beans.Hotel;
import org.capstone.airbnbwebapp.utils.DBUtils;
import org.capstone.airbnbwebapp.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/addHotel" })
public class AddHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AddHotelServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/addHotelView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String area = (String) request.getParameter("area");
        String city = (String) request.getParameter("city");
        String state = (String) request.getParameter("state");
        String country = (String) request.getParameter("country");
        String priceStr = (String) request.getParameter("price");
        String zip = (String) request.getParameter("zip");
        String pin = (String) request.getParameter("pin");
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        }
        Hotel hotel = new Hotel(code, name, area, city, state, country, price, zip, pin);
 
        String errorString = null;
 
        // Hotel ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "\\w+";
 
        if (code == null || !code.matches(regex)) {
            errorString = "Hotel Code invalid!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertHotel(conn, hotel);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("hotel", hotel);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/addHotelView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/hotelList");
        }
    }
 
}
