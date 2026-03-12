package music.repository.mem;

import music.model.Artist;
import music.model.Playlist;
import music.model.Track;
import music.repository.TrackDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("trackDao")
public class MemTrackDao implements TrackDao {

    @Override
    public List<Track> findAll() { return SampleData.tracks; }

    @Override
    public Track findById(int id) {
        return SampleData.tracks.stream()
                .filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Track> findByArtist(Artist a) {
        return SampleData.tracks.stream()
                .filter(t -> t.getArtist() == a).collect(Collectors.toList());
    }

    @Override
    public List<Track> findByPlaylist(Playlist p) {
        return SampleData.tracks.stream()
                .filter(t -> t.getPlaylists().contains(p)).collect(Collectors.toList());
    }

    @Override
    public Track add(Track t) {
        int max = SampleData.tracks.stream().mapToInt(Track::getId).max().orElse(0);
        t.setId(++max);
        SampleData.tracks.add(t);
        return t;
    }
}
