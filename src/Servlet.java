
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

        String id = req.getParameter("id");
        req.setAttribute("id", id);
        /*if(id != null && !id.equals("")) {
            NotesDAOImpl dao = new NotesDAOImpl();
            note = dao.findByID(Integer.parseInt(id));
            req.setAttribute("id", note.getId());
            req.setAttribute("noteName", note.getTitle());
            req.setAttribute("noteText", note.getText());
        }*/
            req.getRequestDispatcher("/note.jsp").forward(req, resp);
    }
        /*resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head><title>Hello World</title></title>");
        pw.println("<body>");
        pw.println("<h1>Hello World</h1>");
        pw.println("</body></html>");
        //PrintWriter printWriter = resp.getWriter();

        String id              = req.getParameter("id");
        String firstName       = req.getParameter("firstName");
        String secondName      = req.getParameter("secondName");
        String hireDateMinimum = req.getParameter("hireDateMinimum");
        String hireDateMaximum = req.getParameter("hireDateMaximum");
        String jobtitle        = req.getParameter("jobtitle");

        pw.println("<h1>Welcome, you request:</h1>");
        pw.println("id = "              + id              + "<br>");
        pw.println("firstName = "       + firstName       + "<br>");
        pw.println("secondName = "      + secondName      + "<br>");
        pw.println("hireDateMinimum = " + hireDateMinimum + "<br>");
        pw.println("hireDateMaximum = " + hireDateMaximum + "<br>");
        pw.println("jobtitle = "        + jobtitle        + "<br>");*/

        /*DepartmentsDaoImpl departmentsDaoImpl = DepartmentsDaoFactory.instance();
        ArrayList<Department> departments =
                (ArrayList<Department>)departmentsDaoImpl.getAll();

        JsonGroup jsonEmployees = new JsonGroup();
        JsonGroup jsonEmployee = null;
        JsonGroup jsonDepartment = null;
        for(Department depar : departments) {
            for(Employee empl : depar.getEmployees()) {

                *//* ======== start filter ========= *//*
                LocalDate localDate = null;

                if (id != null) {
                    if ( ! id.equals(String.valueOf(empl.getId()))) continue;
                } else {
                    if ( (firstName != null)
                            && ( ! firstName.equals(empl.getFirstName())))
                        continue;
                    if ( (secondName != null)
                            && ( ! secondName.equals(empl.getSecondName())))
                        continue;
                    if ( (jobtitle != null)
                            && ( ! jobtitle.equals(empl.getJobtitle())))
                        continue;
                    if (hireDateMinimum != null) {
                        localDate = LocalDate.parse(hireDateMinimum);
                        if (localDate.isAfter(empl.getHireDate()))
                            continue;
                    }
                    if (hireDateMaximum != null) {
                        localDate = LocalDate.parse(hireDateMaximum);
                        if (localDate.isBefore(empl.getHireDate()))
                            continue;
                    }
                }
                *//* -------- end filter --------- *//*

                jsonEmployee = new JsonGroup();

                jsonEmployee.addElement(
                        new JsonElement("id", String.valueOf(empl.getId())));
                jsonEmployee.addElement(
                        new JsonElement("firstName", empl.getFirstName()));
                jsonEmployee.addElement(
                        new JsonElement("secondName", empl.getSecondName()));
                jsonEmployee.addElement(
                        new JsonElement("birthDate", empl.getBirthDate().toString()));
                jsonEmployee.addElement(
                        new JsonElement("hireDate", empl.getHireDate().toString()));
                jsonEmployee.addElement(
                        new JsonElement("jobTitle", empl.getJobtitle()));
                jsonEmployee.addElement(
                        new JsonElement("salary", String.valueOf(empl.getSalary())));

                jsonDepartment = new JsonGroup("department");
                jsonDepartment.addElement(
                        new JsonElement("id", String.valueOf(depar.getId())));
                jsonDepartment.addElement(
                        new JsonElement("name", depar.getName()));
                jsonDepartment.addElement(
                        new JsonElement("description", depar.getDescription()));

                jsonEmployee.addGroup(jsonDepartment);
                jsonEmployees.addGroup(jsonEmployee);
            }
        }*/

        /*pw.println("<h1>You answer:</h1><br>");
        pw.println("<textarea>");
        //printWriter.println(jsonEmployees.getJsonString());
        pw.println("for example");
        pw.println("</textarea>");*/
        }