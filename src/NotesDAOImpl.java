import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedList;

public class NotesDAOImpl implements NotesDAO {
    private static final String JNDI_NAME = "java:comp/env/jdbc/notes";
    private DataSource dataSource;

    public NotesDAOImpl()
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
    public int insert(Note note) {
        String query = "INSERT INTO `notes` (`id`, `title`, `creation_date`, `text`, `author_id`) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, note.getId());
            statement.setString(2, note.getTitle());
            statement.setString(3, note.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setString(4, note.getText());
            statement.setString(5, String.valueOf(note.getOwner().getId()));
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
        String query = "DELETE FROM `notes` WHERE `notes`.`id` = ?";
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
    public Note findByID(int id) {
        String query = "SELECT id, title, text FROM notes WHERE id = ?";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            rs.next();

            Note note = new Note();
            note.setId(Integer.parseInt(rs.getString("id")));
            note.setTitle(rs.getString("title"));
            note.setText(rs.getString("text"));
            con.close();
            return note;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Note note) {
        String query = "UPDATE `notes` SET `title` = ?, `creation_date` = ?, `text` = ?, `author_id` = ? WHERE `notes`.`id` = ?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, note.getTitle());
            statement.setString(2, note.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setString(3, note.getText());
            statement.setString(4, String.valueOf(note.getOwner().getId()));
            statement.setInt(5, note.getId());
            statement.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveOrUpdate(Note note) {
        String query = "SELECT id FROM `notes` WHERE id=?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, note.getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                update(note);
            } else {
                insert(note);
            }
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<Note> findByTitle(String title) {
        String query = "SELECT id FROM `notes` WHERE notes.title = ?";
        LinkedList<Note> found = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                found.add(findByID(rs.getInt("id")));
            }
            con.close();
            return found;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Note> findByTextFragment(String fragment) {
        String query = "SELECT id FROM `notes` WHERE notes.text LIKE ?";
        LinkedList<Note> found = new LinkedList<>();
        fragment = "%" + fragment + "%";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, fragment);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                found.add(findByID(rs.getInt("id")));
            }
            con.close();
            return found;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
