public class User
{
    private int id;
    private String name;
    private String encrypted_password;
    private String eMail;

    public User()
    {

    }
    protected User(String name, String encrypted_password, String eMail, int id)
    {
        this.name = name;
        this.encrypted_password = encrypted_password;
        this.eMail = eMail;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEMail() {
        return eMail;
    }
    protected void setId(int id)
    {
        this.id = id;
    }
    protected void setId()
    {

    }

    public int getId() {
        return id;
    }
}
