package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Blog;
import bitlab.servlets.model.Comment;
import bitlab.servlets.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddCommentServlet", value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        Long blogId = Long.valueOf(request.getParameter("blogId"));
        HttpSession session = request.getSession();
        Users author= (Users) session.getAttribute("CURRENT_USER");

            DBManager.addNewComment(new Comment(null,comment, author.getId(),blogId));
            response.sendRedirect("/main");









    }
}
