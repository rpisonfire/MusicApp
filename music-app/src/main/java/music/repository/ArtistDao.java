package music.repository;

import music.model.Artist;

import java.util.List;

public interface ArtistDao {
    Artist findById(int id);
    List<Artist> findAll();
    Artist add(Artist a);
}
