package music.repository.data;

import music.model.Artist;
import music.repository.ArtistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class DataArtistDao implements ArtistDao {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist findById(int id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist add(Artist a) {
        return artistRepository.save(a);
    }
}
