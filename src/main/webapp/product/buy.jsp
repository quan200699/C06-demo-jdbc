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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
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
<div class="container">
    <div class="card">
        <div class="card-header">
            <h3>Buy product</h3>
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
        </div>
        <div class="card-body">
            <form method="post" action="/product?action=buy&id=${product.id}">
                <div class="mb-3">
                    <p>${product.name}</p>
                </div>

                <div class="mb-3">
                    <p>${product.description}</p>
                </div>

                <div class="mb-3">
                    <p>${product.price}</p>
                </div>
                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input id="amount" type="text" placeholder="product amount" name="amount" >
                </div>
                <button class="btn btn-primary">Buy</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
