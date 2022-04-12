<%@ page import="bitlab.servlets.model.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bitlab.servlets.db.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 04.02.2022
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<div class="container">
    <div class="row-mt-5">
        <div class="col-lg-6">
            <%
                ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blog");
                for(Blog bl: blogs){

            %>

            <p class="text-uppercase"><%=bl.getTitle()%></p>
            <p class="text-lowercase"><%=bl.getDescription()%></p>
            <p class="fst-italic"><%=DBManager.userNameByBlogId((long) bl.getUser_id())%></p>
            <%
                }
            %>
        </div>
    </div>
</div>

  </body>
</html>
