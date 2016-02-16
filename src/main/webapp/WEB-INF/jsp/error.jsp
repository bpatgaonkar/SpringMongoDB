<%-- 
    Document   : error
    Created on : Jan 5, 2016, 10:12:03 PM
    Author     : Patgaonkar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
    <h1>Error Page</h1>
    <p>Application has encountered an error. Please contact support on ...</p>
    
    <b>Exception:</b>  ${exception.message}<br>
    <p>
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
        </c:forEach>
    </p>    
    </body>
    
</html>
