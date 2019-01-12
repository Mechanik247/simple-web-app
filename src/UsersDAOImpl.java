import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedList;

public class UsersDAOImpl implements UsersDAO {
    private static final String JNDI_NAME = "java:comp/env/jdbc/notes";
    private DataSource dataSource;

    public UsersDAOImpl()
    {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            dataSource = (DataSource) ctx.lookup(JNDI_NAME);

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(User user) {
        String query = "INSERT INTO `users` (`id`, `name`, `enctypted_password`, `eMail`) VALUES (?, ?, ?, ?);";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEncrypted_password());
            statement.setString(4, user.getEMail());
            statement.executeUpdate();
            con.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM `users` WHERE `users`.`id` = ?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findByID(int id) {
        String query = "SELECT `id`, `name`, `enctypted_password`, `eMail` FROM `users` WHERE `id` = ?";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            rs.next();

            User user = new User();
            user.setId(Integer.parseInt(rs.getString("id")));
            user.setName(rs.getString("name"));
            user.setEncrypted_password(rs.getString("enctypted_password"));
            user.setEMail(rs.getString("eMail"));
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        String query = "UPDATE `users` SET `name` = ?, `enctypted_password` = ?, `eMail` = ? WHERE `users`.`id` = ?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getEncrypted_password());
            statement.setString(3, user.getEMail());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveOrUpdate(User user) {
        String query = "SELECT id FROM `users` WHERE id=?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, user.getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                update(user);
            } else {
                insert(user);
            }
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<User> findByName(String name) {
        String query = "SELECT id FROM `users` WHERE users.name = ?";
        LinkedList<User> foundedUsers = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                foundedUsers.add(findByID(rs.getInt("id")));
            }
            con.close();
            return foundedUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<User> findByEMail(String eMail) {
        String query = "SELECT id FROM `users` WHERE users.eMail = ?";
        LinkedList<User> foundedUsers = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, eMail);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                foundedUsers.add(findByID(rs.getInt("id")));
            }
            con.close();
            return foundedUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
