
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * This servlet class demonstrates how to access a JNDI DataSource that
 * represents a JDBC connection.
 * @author www.codejava.net
 */
public class Servlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Enter doGet");
        Note note;
        Collection<Note> notes;
        NotesDAOImpl dao = new NotesDAOImpl();

        String insert = req.getParameter("insert");
        String delete = req.getParameter("delete");
        String update = req.getParameter("update");
        String findByID = req.getParameter("findByID");
        String findByTitle = req.getParameter("findByTitle");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String cDate = req.getParameter("cDate");
        String text = req.getParameter("text");
        String author_id = req.getParameter("author_id");


        if (insert != null) {
            note = new Note();
            note.setId(Integer.parseInt(id));
            note.setTitle(title);
            note.setCreationDate(LocalDate.parse(cDate));
            note.setText(text);
            User owner = new User();
            owner.setId(Integer.parseInt(author_id));
            note.setOwner(owner);
            if (dao.insert(note) == 1) {
                req.setAttribute("inf", "Запись добавлена.");
            } else {
                req.setAttribute("inf", "Ошибка добавления!");
            }
        }
        if (update != null) {
            note = new Note();
            note.setId(Integer.parseInt(id));
            note.setTitle(title);
            note.setCreationDate(LocalDate.parse(cDate));
            note.setText(text);
            User owner = new User();
            owner.setId(Integer.parseInt(author_id));
            note.setOwner(owner);
            if (dao.update(note)) {
                req.setAttribute("inf", "Запись обновлена.");
            } else {
                req.setAttribute("inf", "Ошибка обновления!");
            }
        }
        if (delete != null) {
            if (dao.delete(Integer.parseInt(id))) {
                req.setAttribute("inf", "Запись удалена.");
            } else {
                req.setAttribute("inf", "Ошибка удаления!");
            }
        }
        if (findByID != null) {

            note = dao.findByID(Integer.parseInt(id));
            req.setAttribute("id", note.getId());
            req.setAttribute("noteName", note.getTitle());
            req.setAttribute("noteText", note.getText());
        }
        if (findByTitle != null) {

            notes = dao.findByTitle(title);
            req.setAttribute("notes", notes);
            req.getRequestDispatcher("/notes.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/note.jsp").forward(req, resp);
    }

}