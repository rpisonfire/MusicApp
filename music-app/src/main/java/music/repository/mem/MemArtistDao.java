package music.repository.mem;

import music.model.Artist;
import music.repository.ArtistDao;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("artistDao")
public class MemArtistDao implements ArtistDao {

    @Override
    public List<Artist> findAll() { return SampleData.artists; }

    @Override
    public Artist findById(int id) {
        return SampleData.artists.stream()
                .filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Artist add(Artist a) {
        int max = SampleData.artists.stream().mapToInt(Artist::getId).max().orElse(0);
        a.setId(++max);
        SampleData.artists.add(a);
        return a;
    }
}
