package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gfdfyfty");
        int userid = Integer.parseInt(((request.getParameter("userid"))));


        System.out.println(userid);
        ArrayList<Blog> blog = (ArrayList<Blog>) DBManager.getBlogsByUserId(userid);
        System.out.println(blog);
        if(blog!=null){
            request.setAttribute("blog",blog);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/404.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
