<%--
  Created by IntelliJ IDEA.
  User: quan
  Date: 29/09/2021
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Show products list</a>
<h1>Product Create Form</h1>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<form method="post">
    <div>
        <input type="text" placeholder="product name" name="name">
    </div>
    <div>
        <input type="number" placeholder="product price" name="price" value="0">
    </div>
    <div>
        <input type="text" placeholder="product description" name="description">
    </div>
    <div>
        <input type="text" placeholder="product image" name="image">
    </div>
    <button>Create</button>
</form>
</body>
</html>
