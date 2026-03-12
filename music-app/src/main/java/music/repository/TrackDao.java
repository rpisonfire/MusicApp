package music.repository;

import music.model.Artist;
import music.model.Playlist;
import music.model.Track;

import java.util.List;

public interface TrackDao {
    Track findById(int id);
    List<Track> findAll();
    List<Track> findByArtist(Artist a);
    List<Track> findByPlaylist(Playlist p);
    Track add(Track t);
}
