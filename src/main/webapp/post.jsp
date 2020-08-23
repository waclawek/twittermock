<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22.08.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Post page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h3>Write your post:</h3>
    <form action="${pageContext.request.contextPath}/post" method="post">
        <div>
            <label for="content">Your post : </label>
            <input type="text" name="content" id="content" />
        </div>
        <div>
            <input type="submit" value="post">
        </div>
    </form>
</div>
<div class="container">
    <table class="table table-sm">
        <thead>
        <th>Post content</th>
        <th>Author</th>
        <th>Creation</th>
        <th>Delete</th>
        <th>Edit</th>
        </thead>
        <c:forEach items="${posts}" var="post">
            <tr>
                <th scope="row">${post.getContent()}</th>
                <td>${post.getAuthor().getUserName()}</td>
                <td>${post.getCreateAt()}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/deletePost" method="post">
                        <input type="hidden" name="delete" id="delete" value="${post.getId()}"/>
                        <button type="submit" class="btn btn-outline-danger">delete</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/editPost" method="post">
                        <input type="hidden" name="edit" id="edit" value="${post.getId()}"/>
                        <button type="submit" class="btn btn-outline-info">edit</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="users.jsp"%>

</body>
</html>
