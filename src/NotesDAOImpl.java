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


        /*try {

            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/notes");
            dataSource = ds.unwrap(MysqlDataSource.class);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public boolean delete(Note note) {
        /*String query = "DELETE FROM `departments` WHERE `departments`.`id` = ?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, department.getId());
            statement.executeUpdate();
            con.close();
            EmployeesDAOimpl employeesDAOimpl = new EmployeesDAOimpl();
            for (Employee employee : department.getEmployees()) {
                employeesDAOimpl.delete(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return true;
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
        /*String query = "UPDATE `departments` SET `name` = ?, `Description` = ? WHERE `departments`.`id` = ?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, department.getName());
            statement.setString(2, department.getDescription());
            statement.setInt(3, department.getId());
            statement.executeUpdate();
            con.close();
            EmployeesDAOimpl employeesDAOimpl = new EmployeesDAOimpl();
            for (Employee employee : department.getEmployees()) {
                employeesDAOimpl.saveOrUpdate(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return false;
    }

    @Override
    public boolean saveOrUpdate(Note note) {
        /*String query = "SELECT id FROM `departments` WHERE id=?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, department.getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                update(department);
            } else {
                insert(department);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return true;
    }

    @Override
    public Collection<Note> findByTitle(String title) {
        /*String query = "SELECT id FROM `departments` WHERE departments.name = ?";
        LinkedList<Department> found = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                found.add(findByID(rs.getInt("id")));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public Collection<Note> findByTextFragment(String fragment) {
        /*String query = "SELECT id FROM `departments` WHERE departments.name = ?";
        LinkedList<Department> found = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                found.add(findByID(rs.getInt("id")));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return null;
    }
}
