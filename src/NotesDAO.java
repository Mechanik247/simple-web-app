import java.util.Collection;

public interface NotesDAO
{
    public int insert(Note note);
    public boolean delete(int id);
    public Note findByID(int id);
    public boolean update(Note note);
    public boolean saveOrUpdate(Note note);
    public Collection<Note> findByTitle(String title);
    public Collection<Note> findByTextFragment(String fragment);
}
