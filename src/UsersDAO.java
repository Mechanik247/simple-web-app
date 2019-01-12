import java.util.Collection;

public interface UsersDAO
{
    public int insert(User user);
    public boolean delete(int id);
    public User findByID(int id);
    public boolean update(User user);
    public boolean saveOrUpdate(User user);
    public Collection<User> findByName(String name);
    public Collection<User> findByEMail(String eMail);
}
