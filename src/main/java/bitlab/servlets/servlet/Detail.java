package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Blog;
import bitlab.servlets.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Detail", value = "/detail")
public class Detail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(((request.getParameter("userid"))));

        if(request.getSession().getAttribute("CURRENT_USER")!=null){
            ArrayList<Blog> blog = (ArrayList<Blog>) DBManager.getBlogsByUserId(userid);
            System.out.println(blog);
            if(blog!=null){
                request.setAttribute("blog",blog);
                request.getRequestDispatcher("/details.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/404.jsp").forward(request,response);
            }
        }else{
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }
}
