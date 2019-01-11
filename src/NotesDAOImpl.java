import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class NotesDAOImpl implements NotesDAO {
    private static final String JNDI_NAME = "jdbc/notes";
    private MysqlDataSource dataSource;

    public NotesDAOImpl()
    {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = (DataSource) ctx.lookup(JNDI_NAME);
            dataSource = ds.unwrap(MysqlDataSource.class);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dataSource.setAutoReconnect(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(Note note) {
        /*String query = "INSERT INTO `departments` (`id`, `name`, `Description`) VALUES (?, ?, ?)";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            statement.setString(3, department.getDescription());
            statement.executeUpdate();
            con.close();
            EmployeesDAOimpl employeesDAOimpl = new EmployeesDAOimpl();
            for (Employee employee : department.getEmployees()) {
                employeesDAOimpl.saveOrUpdate(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department.getId();*/
        return 0;
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
