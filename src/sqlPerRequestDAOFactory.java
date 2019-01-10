public class sqlPerRequestDAOFactory extends DAOFactory
{

    @Override
    public NotesDAO getNotesDAO() {
        NotesDAOImpl notesDAO = new NotesDAOImpl();
        return notesDAO;
    }

    @Override
    public UsersDAO getUsersDAO() {
        UsersDAOImpl usersDAO = new UsersDAOImpl();
        return usersDAO;
    }
}
