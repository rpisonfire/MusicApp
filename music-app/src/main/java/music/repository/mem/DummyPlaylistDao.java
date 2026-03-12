package music.repository.mem;

import music.model.Playlist;
import music.model.Track;
import music.repository.PlaylistDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyPlaylistDao implements PlaylistDao {

    @Override
    public List<Playlist> findAll() { return new ArrayList<>(); }

    @Override
    public Playlist findById(int id) { return null; }

    @Override
    public List<Playlist> findByTrack(Track t) { return new ArrayList<>(); }

    @Override
    public Playlist add(Playlist p) { return null; }
}
