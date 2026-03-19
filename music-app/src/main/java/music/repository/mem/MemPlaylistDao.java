package music.repository.mem;

import music.model.Playlist;
import music.model.Track;
import music.repository.PlaylistDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("playlistDao")
public class MemPlaylistDao implements PlaylistDao {

    @Override
    public List<Playlist> findAll() { return SampleData.playlists; }

    @Override
    public Playlist findById(int id) {
        return SampleData.playlists.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Playlist> findByTrack(Track t) {
        return SampleData.playlists.stream()
                .filter(p -> p.getTracks().contains(t)).collect(Collectors.toList());
    }

    @Override
    public Playlist add(Playlist p) {
        int max = SampleData.playlists.stream().mapToInt(Playlist::getId).max().orElse(0);
        p.setId(++max);
        SampleData.playlists.add(p);
        return p;
    }
}
