package music.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import music.model.Artist;
import music.model.Playlist;
import music.model.Track;
import music.repository.TrackDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class JpaTrackDao implements TrackDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Track findById(int id) {
        return em.find(Track.class, id);
    }

    @Override
    public List<Track> findAll() {
        return em.createQuery("SELECT t FROM Track t", Track.class)
                .getResultList();
    }

    @Override
    public List<Track> findByArtist(Artist a) {
        return em.createQuery("SELECT t FROM Track t WHERE t.artist = :artist", Track.class)
                .setParameter("artist", a)
                .getResultList();
    }

    @Override
    public List<Track> findByPlaylist(Playlist p) {
        return em.createQuery("SELECT t FROM Track t JOIN t.playlists pl WHERE pl = :playlist", Track.class)
                .setParameter("playlist", p)
                .getResultList();
    }

    @Override
    public Track add(Track t) {
        em.persist(t);
        return t;
    }
}
