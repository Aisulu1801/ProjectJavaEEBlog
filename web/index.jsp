<%@ page import="java.util.ArrayList" %>
<%@ page import="bitlab.servlets.model.Blog" %>
<%@ page import="bitlab.servlets.db.DBManager" %>
<%@ page import="bitlab.servlets.model.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.02.2022
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <%
        ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");
    %>
    <div class="row">
        <div class="col-lg-12">
            <%
                for (Blog blog : blogs) {
            %>
            <div class="blog-item bg-white p-3 mb-3">
                <h3><%=blog.getTitle()%>
                </h3>
                <p><%=blog.getDescription()%>
                </p>
                <p class="fw-bold fst-italic">автор: <%=DBManager.userNameByBlogId(blog.getId())%>
                </p>

                  <a href="/comment?blogId=<%=blog.getId()%>">Комментарии</a>
<%--                <a class="getCommentsButton" href="javascript:void(0)" onclick="getAllCommentsById(<%=blog.getId()%>)">Комментарии</a>--%>


                <form action="/addcomment?blogId=<%=blog.getId()%>" method="post">
                    <div class="row">
                        <div class="col-sm-6">
                            <textarea class="form-control" style="border:none;" name="comment" placeholder="comment"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-light">отправить</button>
                    </div>
                </form>


                <%
                         if(request.getAttribute("comments")!=null){
                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                        for(Comment com: comments){
                            if(blog.getId() == com.getBlog_id()){

                %>
                <p><%=DBManager.userNameByCommentId(com.getId())%><%=com.getComment()%></p>

                <%
                    }
                    }
                    }
                %>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
  
  </body>
</html>
