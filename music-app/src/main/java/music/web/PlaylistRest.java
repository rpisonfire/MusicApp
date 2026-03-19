package music.web;

import lombok.extern.slf4j.Slf4j;
import music.model.Playlist;
import music.model.Track;
import music.service.PlaylistService;
import music.service.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/webapi")
public class PlaylistRest {

    private final PlaylistService playlistService;
    private final TrackService trackService;

    public PlaylistRest(PlaylistService playlistService, TrackService trackService) {
        this.playlistService = playlistService;
        this.trackService = trackService;
    }

    @GetMapping("/playlists")
    public List<Playlist> getAllPlaylists(@RequestParam(required = false) Integer trackId) {
        log.info("GET /webapi/playlists, trackId={}", trackId);

        if (trackId != null) {
            Track track = trackService.getTrackById(trackId);
            if (track == null) return List.of();
            return playlistService.getPlaylistsByTrack(track);
        }

        return playlistService.getAllPlaylists();
    }

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        log.info("POST /webapi/playlists, playlist={}", playlist);
        Playlist saved = playlistService.addPlaylist(playlist);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") int id) {
        log.info("GET /webapi/playlists/{}", id);
        Playlist playlist = playlistService.getPlaylistById(id);
        if (playlist == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(playlist);
    }
}
