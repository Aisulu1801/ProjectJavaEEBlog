package bitlab.servlets.model;

public class Comment {
    private Long id;
    private String comment;
    private Long user_id;
    private Long blog_id;


    public Comment(Long id, String comment, Long user_id, Long blog_id) {
        this.id = id;
        this.comment = comment;
        this.user_id = user_id;
        this.blog_id = blog_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", user_id=" + user_id +
                ", blog_id=" + blog_id +
                '}';
    }
}
