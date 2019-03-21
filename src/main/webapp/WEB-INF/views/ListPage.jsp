<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ListPage</title>
</head>
<body>
<div align="center">
    <h1>Home book</h1>

    <h3><a href="CreateUser">New Contact</a></h3>

    <table border="1">
        <th>id</th>
        <th>Name</th>
        <th>City</th>
        <th>Phone</th>
        <th>Action</th>

        <c:forEach var="user" items="${ListOfUsers}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.name}</td>
                <td>${user.city}</td>
                <td>${user.phone}</td>

                <td>
                    <a href="DeleteUser?id=${user.id}">Delete</a>
                    &nbsp;
                    <a href="UpdateUser?id=${user.id}">Update</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
