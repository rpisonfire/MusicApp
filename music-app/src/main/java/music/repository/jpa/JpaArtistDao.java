package music.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import music.model.Artist;
import music.repository.ArtistDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class JpaArtistDao implements ArtistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Artist findById(int id) {
        return em.find(Artist.class, id);
    }

    @Override
    public List<Artist> findAll() {
        return em.createQuery("SELECT a FROM Artist a", Artist.class)
                .getResultList();
    }

    @Override
    public Artist add(Artist a) {
        em.persist(a);
        return a;
    }
}
