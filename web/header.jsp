<%@ page import="bitlab.servlets.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: darkred">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BLOG</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/main">All Blog</a>
                </li>

                <%
                    Users currentUser = (Users) session.getAttribute("CURRENT_USER");
                    if (currentUser != null) {
                %>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"  href="#" data-bs-toggle="modal" data-bs-target="#addNewBlog">Добавить блог</a>
                </li>



                <div class="ms-auto d-flex">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#"><%=currentUser.getFullName()%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logout">Logout</a>
                    </li>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link active " aria-current="page" href="/profile">Профиль</a>--%>
<%--                    </li>--%>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/detail?userid=<%=currentUser.getId()%>">Детали</a>
                    </li>
                </div>
                <%
                        }else {
                %>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/register">Register</a>
                </li>
                <%
                    }
                %>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>


    <div class="modal fade" id="addNewBlog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Написать блог</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/add-blog" method="post">
                        <div class="mb-3">
                            <label for="blogTitle" class="form-label">Наименование</label>
                            <input type="text" class="form-control" id="blogTitle" name="blogTitle">
                        </div>
                        <div class="form-floating">
                            <textarea class="form-control" name="blogContent" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
                            <label for="floatingTextarea">Content</label>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Добавить блог</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</nav>
</body>
</html>
