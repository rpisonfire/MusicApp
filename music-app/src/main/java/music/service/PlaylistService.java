package music.service;

import music.model.Playlist;
import music.model.Track;

import java.util.List;

public interface PlaylistService {
    Playlist addPlaylist(Playlist p);
    Playlist getPlaylistById(int id);
    List<Playlist> getAllPlaylists();
    List<Playlist> getPlaylistsByTrack(Track t);
    List<Track> getTracksInPlaylist(Playlist p);
}
