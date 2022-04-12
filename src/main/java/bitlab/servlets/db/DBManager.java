package bitlab.servlets.db;

import bitlab.servlets.model.Blog;
import bitlab.servlets.model.Comment;
import bitlab.servlets.model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Connection connection;

    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bitweb?useUnicode=true&serverTimezone=UTC","root","");
            System.out.println("DBCONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Blog> getAllBlog(){
        ArrayList<Blog> blog = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from blog");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                blog.add(new Blog(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getInt("user_id")

                        ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }

    public static String userNameByBlogId( Long id){
        String userName = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select users.fullName" + " "+
                    "from users join blog b on users.id = b.user_id where b.id = ?");
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
               userName = result.getString("fullName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public static String userNameByCommentId( Long id){
        String authorName = null;
        try {
            PreparedStatement statement =connection.prepareStatement("select users.fullName" +
                   "from users join comment c on users.id = c.user_id where c.id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                authorName = resultSet.getString("fullName");
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return authorName;
    }
    public  static Users getUserByEmail(String email){
        Users user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("select * from users where email=?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName")
                );

            }

            statement.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
        return user;
    }



    public static List<Comment> getCommentsByBlogId(Long blogId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from comment where blog_id = ? order by id desc ");
            statement.setLong(1, blogId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long id = result.getLong("id");
                String comment = result.getString("comment");
                Long user_id = result.getLong("user_id");
                comments.add(new Comment(id, comment, user_id, blogId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public static ArrayList<Blog> getBlogsByUserId(int userid) {
        ArrayList<Blog> blogs = new ArrayList<>();
        System.out.println(userid);
        try {
            PreparedStatement statement = connection.prepareStatement("select * from blog where user_id = ?");
            statement.setInt(1, userid);
            ResultSet result = statement.executeQuery();
            System.out.println(result.toString());
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int Userid = result.getInt("user_id");
                System.out.println(id);
                System.out.println(title);
                System.out.println(description);
                System.out.println(userid);
                blogs.add(new Blog(id,title,description,Userid));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(blogs);
        return blogs;
    }




    public static boolean addNewUser(Users users){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into users (email,password,fullName)" + "values(?,?,?)");

            statement.setString(1,users.getEmail());
            statement.setString(2,users.getPassword());
            statement.setString(3,users.getFullName());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean addNewBlog(Blog blog){
        int rows = 0 ;
        try{
            PreparedStatement statement =connection.prepareStatement("insert into blog (title,description,user_id)" + "values (?,?,?)");

            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getDescription());
            statement.setLong(3,blog.getUser_id());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean addNewComment(Comment comment){
        int rows = 0 ;
        try{
            PreparedStatement statement =connection.prepareStatement("insert into comment (comment,user_id,blog_id)" + "values (?,?,?)");

            statement.setString(1,comment.getComment());
            statement.setLong(2,comment.getUser_id());
            statement.setLong(3,comment.getBlog_id());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return rows>0;
    }

}
