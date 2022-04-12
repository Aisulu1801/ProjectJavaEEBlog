package bitlab.servlets.servlet;

import bitlab.servlets.db.DBManager;
import bitlab.servlets.model.Comment;
import com.google.gson.Gson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long blogId = Long.parseLong(request.getParameter("blogId"));
                request.setAttribute("blogs", DBManager.getAllBlog());
        request.setAttribute("comments", DBManager.getCommentsByBlogId(blogId));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
