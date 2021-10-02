<%--
  Created by IntelliJ IDEA.
  User: quan
  Date: 29/09/2021
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/product">Product Management</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/category">Category Management</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="card">
    <div class="card-header">
        <h3>Product Create Form</h3>
    </div>
    <div class="card-body">
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
        <form action="/product?action=create" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input id="name" type="text" placeholder="product name" name="name">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input id="price" type="number" placeholder="product price" name="price" value="0">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input id="description" type="text" placeholder="product description" name="description" >
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image</label>
                <input id="image" type="text" placeholder="product image" name="image" >
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
