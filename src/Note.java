import java.time.LocalDate;
import java.util.Map;

public class Note
{
    private int id;
    private String title;
    private String text;
    private LocalDate creationDate;
    private User owner;
    private Map<User, Rights> privileges;

    public Note(){}
    public Note(String title, String text, LocalDate cDate, User owner)
    {
        this.title = title;
        this.text = text;
        this.creationDate = cDate;
        this.owner = owner;
    }
    public Note(String title, String text, LocalDate cDate, User owner, Map<User, Rights> privileges, int id)
    {
        this.title = title;
        this.text = text;
        this.creationDate = cDate;
        this.owner = owner;
        this.privileges = privileges;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public Map<User, Rights> getPrivileges() {
        return privileges;
    }
    public void putPrivilege(User user, Rights rights)
    {

    }
    public  Rights getPrivilege(User user)
    {
        return null;
    }
    public void removePrivilege(User user)
    {

    }
    protected void setId(int id)
    {
        this.id = id;
    }
    protected void setId(){}
    public int getId()
    {
        return id;
    }
}
