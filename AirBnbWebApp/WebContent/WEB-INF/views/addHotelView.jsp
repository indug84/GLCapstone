<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Add New Hotel</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Add Hotel</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/addHotel">
         <table border="0">
            <tr>
               <td>Code</td>
               <td><input type="text" name="code" value="${hotel.code}" /></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${hotel.name}" /></td>
            </tr>
            <tr>
               <td>Area</td>
               <td><input type="text" name="area" value="${hotel.area}" /></td>
            </tr>
            <tr>
               <td>City</td>
               <td><input type="text" name="city" value="${hotel.city}" /></td>
            </tr>
            <tr>
               <td>State</td>
               <td><input type="text" name="state" value="${hotel.state}" /></td>
            </tr>
            <tr>
               <td>Country</td>
               <td><input type="text" name="country" value="${hotel.country}" /></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="text" name="price" value="${product.price}" /></td>
            </tr>
            <tr>
               <td>Zip</td>
               <td><input type="text" name="zip" value="${hotel.zip}" /></td>
            </tr>
            <tr>
               <td>Pin</td>
               <td><input type="text" name="pin" value="${hotel.pin}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="hotelList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>