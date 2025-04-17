import java.util.Date;

public class EditMessage {
    private String message;
    private String username;
    private Date postedDate;

    public EditMessage(String message, User user) {
        this.message = message;
        this.username = user.getUsername();
        this.postedDate = new Date();
    }

    @Override
    public String toString() {
        return "edit suggested by " + username + " on " + postedDate + ":\n" + message;
    }
}