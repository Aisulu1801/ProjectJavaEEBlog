<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2022
  Time: 21:08
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
    <div class="row mt-5">
        <div class="col-lg-6 offset-3">
            <h4 class="mb-4">
                Login to system
            </h4>

            <%
                String success =request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-info" role="alert">
                User added successfully!
            </div>
            <%
                }
            %>

            <%
                String passworderror =request.getParameter("passworderror");
                if(passworderror!=null){
            %>
            <div class="alert alert-danger" role="alert">
                Password incorrect!
            </div>
            <%
                }
            %>


            <%
                String emailerror =request.getParameter("emailerror");
                if(emailerror!=null){
            %>
            <div class="alert alert-danger" role="alert">
                User exists!
            </div>
            <%
                }
            %>
            <form action="/toregister" method="post">

                <div class="form-group">
                    <label>EMAIL:</label>
                    <input type="email" required name="email" class="form-control">
                </div>

                <div class="form-group">
                    <label>PASSWORD:</label>
                    <input type="password" required name="password" class="form-control">
                </div>

                <div class="form-group">
                    <label> RE TYPE PASSWORD:</label>
                    <input type="password" required name="re_type_password" class="form-control">
                </div>

                <div class="form-group">
                    <label> FULL_NAME:</label>
                    <input type="text" required name="fullname" class="form-control">
                </div>


                <br>
                <br>

                <div class="form-group">
                    <button class="btn btn-success">REGISTER</button>
                </div>
            </form>



        </div>
    </div>
</div>


  </body>
</html>
