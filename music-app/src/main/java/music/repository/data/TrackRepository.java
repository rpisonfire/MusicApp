package music.repository.data;

import music.model.Artist;
import music.model.Playlist;
import music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByArtist(Artist artist);
    List<Track> findByPlaylists(Playlist playlist);
}
