package org.capstone.airbnbwebapp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import org.capstone.airbnbwebapp.beans.Hotel;
import org.capstone.airbnbwebapp.beans.UserAccount;
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static List<Hotel> queryHotel(Connection conn) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Area, a.City, a.State, a.Country, a.Price, a.Zip, a.Pin from hotel a ";
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        
        List<Hotel> list = new ArrayList<Hotel>();
        if (rs.next() == false) { System.out.println("ResultSet in empty in Java"); }

       
        while (rs.next()) {
            String code = rs.getString("Code");
            String name = rs.getString("Name");
            String area = rs.getString("Area");
            String city = rs.getString("City");
            String state = rs.getString("State");
            String country = rs.getString("Country");
            float price = rs.getFloat("Price");
			String zip = rs.getString("Zip");
			String pin = rs.getString("Pin");
            Hotel hotel = new Hotel();
            hotel.setCode(code);
            hotel.setName(name);
            hotel.setArea(area);
            hotel.setCity(city);
            hotel.setState(state);
            hotel.setCountry(country);
            hotel.setPrice(price);
            hotel.setZip(zip);
            hotel.setPin(pin);
            list.add(hotel);
        }
        return list;
    }
 
    public static Hotel findHotel(Connection conn, String code) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Area, a.City, a.State, a.Country, a.Price, a.Zip, a.Pin from Hotel a where a.Code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            String area = rs.getString("Area");;
            String city = rs.getString("City");;
            String state = rs.getString("State");;
            String country = rs.getString("Country");;
            float price = rs.getFloat("Price");
			String zip = rs.getString("Zip");
			String pin = rs.getString("Pin");
            Hotel hotel = new Hotel(code, name, area, city, state, country, price, zip, pin);
            return hotel;
        }
        return null;
    }
 
    public static void updateHotel(Connection conn, Hotel hotel) throws SQLException {
        String sql = "Update Hotel set Name =?, Price=? where Code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, hotel.getName());
        pstm.setFloat(2, hotel.getPrice());
        pstm.setString(3, hotel.getCode());
        pstm.executeUpdate();
    }
 
    public static void insertHotel(Connection conn, Hotel hotel) throws SQLException {
        String sql = "Insert into Hotel(Code, Name, Area, City, State, Country, Price, Zip, Pin) values (?,?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, hotel.getCode());
        pstm.setString(2, hotel.getName());
        pstm.setString(3, hotel.getArea());
        pstm.setString(4, hotel.getCity());
        pstm.setString(5, hotel.getState());
        pstm.setString(6, hotel.getCountry());
        pstm.setFloat(7, hotel.getPrice());
        pstm.setString(8, hotel.getZip());
        pstm.setString(9, hotel.getPin());
 
        pstm.executeUpdate();
    }
 
    public static void deleteHotel(Connection conn, String code) throws SQLException {
        String sql = "Delete From Hotel where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
 
}
