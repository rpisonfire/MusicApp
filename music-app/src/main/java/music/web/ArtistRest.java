package music.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import music.model.Artist;
import music.model.Track;
import music.service.TrackService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/webapi")
public class ArtistRest {

    private final TrackService trackService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    public ArtistRest(TrackService trackService, MessageSource messageSource, LocaleResolver localeResolver) {
        this.trackService = trackService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/artists")
    public List<Artist> getAllArtists(@RequestParam(value = "phrase", required = false) String phrase) {
        log.info("GET /webapi/artists");
        if ("foo".equals(phrase)) {
            throw new IllegalArgumentException("Exception's test");
        }
        return trackService.getAllArtists();
    }


    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") int id) {
        log.info("GET /webapi/artists/{}", id);
        Artist artist = trackService.getArtistById(id);
        if (artist == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(artist);
    }

    @GetMapping("/artists/{id}/tracks")
    public ResponseEntity<List<Track>> getTracksByArtist(@PathVariable("id") int id) {
        log.info("GET /webapi/artists/{}/tracks", id);
        Artist artist = trackService.getArtistById(id);
        if (artist == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(trackService.getTracksByArtist(artist));
    }

    @PostMapping("/artists")
    public ResponseEntity<?> addArtist(@RequestBody @Validated ArtistDTO artistDTO, Errors errors, HttpServletRequest request) {
        log.info("POST /webapi/artists, artistDTO={}", artistDTO);
        if (errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe -> messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe) -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        Artist artist = new Artist();
        artist.setFirstName(artistDTO.getFirstName());
        artist.setLastName(artistDTO.getLastName());

        Artist saved = trackService.addArtist(artist);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + saved.getId())
                                .build()
                                .toUri())
                .body(saved);
    }

}
