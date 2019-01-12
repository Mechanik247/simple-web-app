public abstract class DAOFactory {
    protected DAOFactory(){}
    public static DAOFactory getDaoFactory()
    {
        sqlPerRequestDAOFactory sql = new sqlPerRequestDAOFactory();
        return sql;
    }
    public abstract NotesDAO getNotesDAO();
    public abstract UsersDAO getUsersDAO();
}
