package music.service.impl;

import music.model.Playlist;
import music.model.Track;
import music.repository.PlaylistDao;
import music.repository.TrackDao;
import music.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
//@Scope("prototype")
public class PlaylistServiceBean implements PlaylistService {

    private static final Logger log = Logger.getLogger(PlaylistService.class.getName());

    private PlaylistDao playlistDao;
    private TrackDao trackDao;

    public PlaylistServiceBean(PlaylistDao playlistDao, TrackDao trackDao) {
        log.info("creating playlist service bean");
        this.playlistDao = playlistDao;
        this.trackDao = trackDao;
    }

    @Override
    public Playlist addPlaylist(Playlist p) {
        log.info("adding playlist " + p);
        return playlistDao.add(p);
    }

    @Override
    public Playlist getPlaylistById(int id) {
        log.info("searching playlist by id " + id);
        return playlistDao.findById(id);
    }

    @Override
    public List<Track> getTracksInPlaylist(Playlist p) {
        log.info("searching tracks in playlist " + p.getId());
        return trackDao.findByPlaylist(p);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        log.info("searching all playlists");
        return playlistDao.findAll();
    }

    @Override
    public List<Playlist> getPlaylistsByTrack(Track t) {
        log.info("searching playlists by track " + t.getId());
        return playlistDao.findByTrack(t);
    }
}
