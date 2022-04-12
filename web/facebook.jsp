<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.02.2022
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facebook</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>

<style>
.left{
    margin: 10%;
    margin-top: 25%;
}
.right{
    margin-top: 25%;
    padding: 20px;
    border: gray 1px solid;
    border-radius: 8px;
    box-shadow: 2px 5px 5px 5px;


}
h1{
    color: #1876F1;
    font-size: 60px;
}
.new{
    background-color: #42B72A;
}
.connexion{
    width: 100%;
    background-color: #1876F1;
}
.flex{
    justify-content: space-around;
}

</style>
<div class="container">
    <div class="row flex">

        <div class="col-lg-6 left" >

            <h1>facebook</h1>
            <h5>
                Facebook помогает вам всегда оставаться на связи и общаться со своими знакомыми.
            </h5>


        </div>
        <div class="col-lg-4 mt-3 ">
            <form class="right">
                <div class="form-group">

                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Address email ">

                </div>
                <div class="form-group">

                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password">
                </div>
                <button type="submit" class="btn btn-primary connexion">Вход</button> <br>
                <a href="">Забыли пароль?</a><br>

                <button type="button" class="btn btn-success new">Создать новый аккаунт</button>
            </form>


        </div>

    </div>

</div>
  
  </body>
</html>
