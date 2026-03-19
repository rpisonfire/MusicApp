package music.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import music.model.Playlist;
import music.model.Track;
import music.repository.PlaylistDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class JpaPlaylistDao implements PlaylistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Playlist findById(int id) {
        return em.find(Playlist.class, id);
    }

    @Override
    public List<Playlist> findAll() {
        return em.createQuery("SELECT p FROM Playlist p", Playlist.class)
                .getResultList();
    }

    @Override
    public List<Playlist> findByTrack(Track t) {
        return em.createQuery("SELECT p FROM Playlist p JOIN p.tracks t WHERE t = :track", Playlist.class)
                .setParameter("track", t)
                .getResultList();
    }

    @Override
    public Playlist add(Playlist p) {
        em.persist(p);
        return p;
    }
}
