import java.util.Collection;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User user) {
        return false;
    }

    @Override
    public Collection<User> findByName(String name) {
        return null;
    }

    @Override
    public Collection<User> findByEMail(String eMail) {
        return null;
    }
}
