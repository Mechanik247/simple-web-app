import java.util.Collection;

public class NotesDAOImpl implements NotesDAO {
    @Override
    public int insert(Note note) {
        return 0;
    }

    @Override
    public boolean delete(Note note) {
        return false;
    }

    @Override
    public Note findByID(int id) {
        return null;
    }

    @Override
    public boolean update(Note note) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Note note) {
        return false;
    }

    @Override
    public Collection<Note> findByTitle(String title) {
        return null;
    }

    @Override
    public Collection<Note> findByTextFragment(String fragment) {
        return null;
    }
}
