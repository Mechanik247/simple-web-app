
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

public class Servlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Enter doGet");
        Note note;
        User user;
        Collection<Note> notes;
        Collection<User> users;
        NotesDAOImpl notesDAO = new NotesDAOImpl();
        UsersDAOImpl usersDAO = new UsersDAOImpl();

        String insert = req.getParameter("insert");
        String delete = req.getParameter("delete");
        String update = req.getParameter("update");
        String findByID = req.getParameter("findByID");
        String findByTitle = req.getParameter("findByTitle");
        String findByName = req.getParameter("findByName");
        String findByEMail = req.getParameter("findByEMail");
        String findByTextFragment = req.getParameter("findByTextFragment");
        String saveOrUpdate = req.getParameter("saveOrUpdate");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String cDate = req.getParameter("cDate");
        String text = req.getParameter("text");
        String fragment = req.getParameter("fragment");
        String author_id = req.getParameter("author_id");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String eMail = req.getParameter("eMail");


        if (insert != null) {
            if(insert.equals("note")) {
                if(id != null && title != null && cDate != null && text != null && author_id != null) {
                    note = new Note();
                    note.setId(Integer.parseInt(id));
                    note.setTitle(title);
                    note.setCreationDate(LocalDate.parse(cDate));
                    note.setText(text);
                    User owner = new User();
                    owner.setId(Integer.parseInt(author_id));
                    note.setOwner(owner);
                    if (notesDAO.insert(note) == 1) {
                        req.setAttribute("inf", "Запись добавлена.");
                    } else {
                        req.setAttribute("inf", "Ошибка добавления!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            else if(insert.equals("user")) {
                if(id != null && name != null && pass != null && eMail != null) {
                    user = new User();
                    user.setId(Integer.parseInt(id));
                    user.setName(name);
                    user.setEncrypted_password(pass);
                    user.setEMail(eMail);
                    if (usersDAO.insert(user) == 1) {
                        req.setAttribute("inf", "Запись добавлена.");
                    } else {
                        req.setAttribute("inf", "Ошибка добавления!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            req.getRequestDispatcher("/inf.jsp").forward(req, resp);
        }
        else if (update != null) {
            if(update.equals("note")) {
                if(id != null && title != null && cDate != null && text != null && author_id != null) {
                    note = new Note();
                    note.setId(Integer.parseInt(id));
                    note.setTitle(title);
                    note.setCreationDate(LocalDate.parse(cDate));
                    note.setText(text);
                    User owner = new User();
                    owner.setId(Integer.parseInt(author_id));
                    note.setOwner(owner);
                    if (notesDAO.update(note)) {
                        req.setAttribute("inf", "Запись обновлена.");
                    } else {
                        req.setAttribute("inf", "Ошибка обновления!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            else if(update.equals("user"))
            {
                if(id != null && name != null && pass != null && eMail != null) {
                    user = new User();
                    user.setId(Integer.parseInt(id));
                    user.setName(name);
                    user.setEncrypted_password(pass);
                    user.setEMail(eMail);
                    if (usersDAO.update(user)) {
                        req.setAttribute("inf", "Запись обновлена.");
                    } else {
                        req.setAttribute("inf", "Ошибка обновления!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            req.getRequestDispatcher("/inf.jsp").forward(req, resp);
        }
        else if (saveOrUpdate != null) {
            if(saveOrUpdate.equals("note")) {
                if(id != null && title != null && cDate != null && text != null && author_id != null) {
                    note = new Note();
                    note.setId(Integer.parseInt(id));
                    note.setTitle(title);
                    note.setCreationDate(LocalDate.parse(cDate));
                    note.setText(text);
                    User owner = new User();
                    owner.setId(Integer.parseInt(author_id));
                    note.setOwner(owner);
                    if (notesDAO.saveOrUpdate(note)) {
                        req.setAttribute("inf", "Запись сохранена.");
                    } else {
                        req.setAttribute("inf", "Ошибка сохранения!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            else if(saveOrUpdate.equals("user"))
            {
                if(id != null && name != null && pass != null && eMail != null) {
                    user = new User();
                    user.setId(Integer.parseInt(id));
                    user.setName(name);
                    user.setEncrypted_password(pass);
                    user.setEMail(eMail);
                    if (usersDAO.saveOrUpdate(user)) {
                        req.setAttribute("inf", "Запись сохранена.");
                    } else {
                        req.setAttribute("inf", "Ошибка сохранения!");
                    }
                }
                else
                {
                    req.setAttribute("inf", "Ошибка! Введены не все параметры!");
                }
            }
            req.getRequestDispatcher("/inf.jsp").forward(req, resp);
        }
        else if (delete != null) {
            if(delete.equals("note")) {
                if (notesDAO.delete(Integer.parseInt(id))) {
                    req.setAttribute("inf", "Запись удалена.");
                } else {
                    req.setAttribute("inf", "Ошибка удаления!");
                }
            }
            else if(delete.equals("user"))
            {
                if (usersDAO.delete(Integer.parseInt(id))) {
                    req.setAttribute("inf", "Запись удалена.");
                } else {
                    req.setAttribute("inf", "Ошибка удаления!");
                }
            }
            req.getRequestDispatcher("/inf.jsp").forward(req, resp);
        }
        else if (findByID != null) {
            if(findByID.equals("note")) {
                note = notesDAO.findByID(Integer.parseInt(id));
                req.setAttribute("id", note.getId());
                req.setAttribute("title", note.getTitle());
                req.setAttribute("text", note.getText());
                req.setAttribute("cDate", note.getCreationDate());
                req.setAttribute("author_id", note.getOwner().getId());

                req.getRequestDispatcher("/note.jsp").forward(req, resp);
            }
            else if(findByID.equals("user"))
            {
                user = usersDAO.findByID(Integer.parseInt(id));
                req.setAttribute("id", user.getId());
                req.setAttribute("name", user.getName());
                req.setAttribute("pass", user.getEncrypted_password());
                req.setAttribute("eMail", user.getEMail());

                req.getRequestDispatcher("/user.jsp").forward(req, resp);
            }
        }
        else if (findByTitle != null) {

            notes = notesDAO.findByTitle(title);
            req.setAttribute("notes", notes);
            req.getRequestDispatcher("/notes.jsp").forward(req, resp);
        }
        else if (findByName != null) {

            users = usersDAO.findByName(name);
            req.setAttribute("users", users);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        }
        else if (findByEMail != null) {

            users = usersDAO.findByEMail(eMail);
            req.setAttribute("users", users);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        }
        else if (findByTextFragment != null) {

            notes = notesDAO.findByTextFragment(fragment);
            req.setAttribute("notes", notes);
            req.getRequestDispatcher("/notes.jsp").forward(req, resp);
        }

    }

}