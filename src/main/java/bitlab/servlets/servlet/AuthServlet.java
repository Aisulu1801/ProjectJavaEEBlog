package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/login?emailerror";

        Users users = DBManager.getUserByEmail(email);
        if(users!=null){
            redirect = "/login?passworderror";
            if(users.getPassword().equals(password)){

              HttpSession session = request.getSession();
              session.setAttribute("CURRENT_USER",users);
              redirect = "/";
            }
        }
        response.sendRedirect(redirect);

    }
}
