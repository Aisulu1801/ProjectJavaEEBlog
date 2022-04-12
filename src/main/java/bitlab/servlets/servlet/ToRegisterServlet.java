package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToRegisterServlet", value = "/toregister")
public class ToRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_type_password = request.getParameter("re_type_password");
        String fullname = request.getParameter("fullname");

        String redirect = "/register?passworderror";

        if(password.equals(re_type_password)){
            redirect = "/register?emailerror";
            Users users = DBManager.getUserByEmail(email);

            if(users ==null){

                Users newUser = new Users(null, email,password,fullname);

                if(DBManager.addNewUser(newUser)){
                    redirect = "/register?success";
                }
            }
        }
        response.sendRedirect(redirect);

    }
}
