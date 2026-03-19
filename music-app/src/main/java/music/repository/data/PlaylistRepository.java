package music.repository.data;

import music.model.Playlist;
import music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    @Query("SELECT p FROM Playlist p JOIN p.tracks t WHERE t = :track")
    List<Playlist> findByTrack(@Param("track") Track track);
}
