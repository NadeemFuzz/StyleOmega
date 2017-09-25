package styleomega.cb006456.styleomega.Model;

/**
 * Created by Nadeem on 8/29/2017.
 */

public class Contact {

    private int id;
    private String name;
    private String email;
    private String message;
    private String reply;

    public Contact(int id, String name, String email, String message, String reply) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.reply=reply;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
