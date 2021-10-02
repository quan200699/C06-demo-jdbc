<%--
  Created by IntelliJ IDEA.
  User: quan
  Date: 29/09/2021
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product list by category</h1>
<a href="/category"></a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Image</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <th scope="row">${product.id}</th>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><img src="${product.image}" alt="ava" height="100" width="100"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
