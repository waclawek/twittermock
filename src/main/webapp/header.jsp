<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-light bg-light">
        <span class="navbar-brand mb-0 h3">
            Welcome : <%= session.getAttribute("username")%>
            <a class="btn btn-outline-secondary btn-sm " href="/logout" role="button">logout</a>
        </span>
    </nav>
</header>
