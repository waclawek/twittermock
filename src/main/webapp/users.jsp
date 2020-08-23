<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <table class="table table-sm">
        <thead>
        <th>User name</th>
        <th>Follow</th>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <th scope="row">${user.getUserName()}</th>
                <td>
                    <c:choose>
                        <c:when test="${user.getUserName().equals(username)}">
                            <button type="button" class="btn btn-secondary btn-sm" disabled>you</button>
                        </c:when>
                        <c:when test="${followees.contains(user.getUserName())}">
                            <form action="${pageContext.request.contextPath}/unfollow" method="post">
                                <input type="hidden" name="unfollow" id="unfollow" value="${user.getUserName()}"/>
                                <button type="submit" class="btn btn-warning btn-sm">unfollow</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="${pageContext.request.contextPath}/follow" method="post">
                                <input type="hidden" name="follow" id="follow" value="${user.getUserName()}"/>
                                <button type="submit" class="btn btn-success btn-sm">follow</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>