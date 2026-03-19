package music.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import music.model.Artist;
import music.model.Playlist;
import music.model.Track;
import music.service.PlaylistService;
import music.service.TrackService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/webapi")
public class TrackRest {

    private final TrackService trackService;
    private final PlaylistService playlistService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    public TrackRest(TrackService trackService, PlaylistService playlistService,
                     MessageSource messageSource, LocaleResolver localeResolver) {
        this.trackService = trackService;
        this.playlistService = playlistService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/tracks")
    public List<Track> getAllTracks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer artistId,
            @RequestParam(required = false) Integer playlistId) {

        log.info("GET /webapi/tracks, title={}, artistId={}, playlistId={}", title, artistId, playlistId);

        if (artistId != null) {
            Artist artist = trackService.getArtistById(artistId); // ✅ TrackService
            if (artist == null) return List.of();
            return trackService.getTracksByArtist(artist);
        }

        if (playlistId != null) {
            Playlist playlist = playlistService.getPlaylistById(playlistId);
            if (playlist == null) return List.of();
            return playlistService.getTracksInPlaylist(playlist); // ✅ PlaylistService
        }

        if (title != null) {
            return trackService.getAllTracks().stream()
                    .filter(t -> t.getTitle().equalsIgnoreCase(title))
                    .toList();
        }

        return trackService.getAllTracks();
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable("id") int id) {
        log.info("GET /webapi/tracks/{}", id);
        Track track = trackService.getTrackById(id);
        if (track == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(track);
    }

    @PostMapping("/tracks")
    public ResponseEntity<?> addTrack(@Validated @RequestBody Track track, Errors errors,
                                      HttpServletRequest request) {
        log.info("POST /webapi/tracks, track={}", track);
        if (errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe -> messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe) -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        Track saved = trackService.addTrack(track);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
