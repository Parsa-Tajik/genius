package src;

import java.util.Date;

public class Comment {
    private String content;
    private String username;
    private Date postedDate;

    public Comment(String content, User user) {
        this.content = content;
        this.username = user.getUsername();
        this.postedDate = new Date();
    }

    @Override
    public String toString() {
        return "Comment by " + username + " on " + postedDate + ":\n" + content;
    }
}