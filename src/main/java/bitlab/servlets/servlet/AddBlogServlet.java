package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Blog;
import bitlab.servlets.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBlogServlet", value = "/add-blog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String blogTitle = request.getParameter("blogTitle");
         String blogContent = request.getParameter("blogContent");

         HttpSession session = request.getSession();
        Users author= (Users) session.getAttribute("CURRENT_USER");
        DBManager.addNewBlog(new Blog(null,blogTitle,blogContent, Math.toIntExact(author.getId())));

        response.sendRedirect("/main");

    }
}
