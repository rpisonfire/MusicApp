package music.repository.data;

import music.model.Playlist;
import music.model.Track;
import music.repository.PlaylistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class DataPlaylistDao implements PlaylistDao {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Playlist findById(int id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> findByTrack(Track t) {
        return playlistRepository.findByTrack(t);
    }

    @Override
    public Playlist add(Playlist p) {
        return playlistRepository.save(p);
    }
}
