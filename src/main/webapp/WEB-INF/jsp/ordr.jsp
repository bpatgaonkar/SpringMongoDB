<%-- 
    Document   : output
    Created on : Jan 1, 2016, 4:46:51 PM
    Author     : Patgaonkar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>Here is a simple CRUD using Spring MVC and MongoDB.</title></head>
    <body>
        <h2>Order Form</h2>
        <form action="order/save" method="post">
            <input type="hidden" name="id">
            <label for="name">Product Name</label>
            <input type="text" id="name" name="name"/>
            <input type="submit" value="Submit"/>
        </form>
        <table border="1">
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td>${order.id}</td>
                    <td>
                        <input type="button" value="delete" onclick="window.location = 'order/delete?id=${order.id}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

