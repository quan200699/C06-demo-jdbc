<%--
  Created by IntelliJ IDEA.
  User: quan
  Date: 01/10/2021
  Time: 09:51
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
<h1>Delete product form</h1>
<form method="post">
    <div>
        <p>${product.name}</p>
    </div>

    <div>
        <p>${product.description}</p>
    </div>

    <div>
        <p>${product.price}</p>
    </div>

    <div>
        <p>${product.image}</p>
    </div>
    <button>Delete</button>
</form>
</body>
</html>
