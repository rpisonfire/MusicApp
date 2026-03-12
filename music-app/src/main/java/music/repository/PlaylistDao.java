package music.repository;

import music.model.Playlist;
import music.model.Track;

import java.util.List;

public interface PlaylistDao {
    Playlist findById(int id);
    List<Playlist> findAll();
    List<Playlist> findByTrack(Track t);
    Playlist add(Playlist p);
}
