package music.repository.data;

import music.model.Artist;
import music.model.Playlist;
import music.model.Track;
import music.repository.TrackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class DataTrackDao implements TrackDao {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Track findById(int id) {
        return trackRepository.findById(id).orElse(null);
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> findByArtist(Artist a) {
        return trackRepository.findByArtist(a);
    }

    @Override
    public List<Track> findByPlaylist(Playlist p) {
        return trackRepository.findByPlaylists(p);
    }

    @Override
    public Track add(Track t) {
        return trackRepository.save(t);
    }
}
