<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Hotel List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Hotel List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Area</th>
          <th>City</th>
          <th>State</th>
          <th>Country</th>
          <th>Price</th>
          <th>Zip</th>
          <th>Pin</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${hotelList}" var="hotel" >
          <tr>
             <td>${hotel.code}</td>
             <td>${hotel.name}</td>
             <td>${hotel.area}</td>
             <td>${hotel.city}</td>
             <td>${hotel.state}</td>
             <td>${hotel.country}</td>
             <td>${hotel.price}</td>
             <td>${hotel.zip}</td>
             <td>${hotel.pin}</td>
             <td>
                <a href="editHotel?code=${hotel.code}">Edit</a>
             </td>
             <td>
                <a href="deleteHotel?code=${hotel.code}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="addHotel" >Create Hotel</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>