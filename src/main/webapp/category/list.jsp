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
<h1>Category list</h1>
<a href="/category?action=create">Create new category</a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <th scope="row">${category.id}</th>
            <td>
                <a href="/category?action=view&id=${category.id}">
                        ${category.name}
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
