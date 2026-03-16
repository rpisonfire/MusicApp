package music.web;

import music.web.TrackValidator;
import music.web.ArtistValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MusicAdvice {

    private final TrackValidator trackValidator;
    private final ArtistValidator artistValidator;

    public MusicAdvice(TrackValidator trackValidator, ArtistValidator artistValidator) {
        this.trackValidator = trackValidator;
        this.artistValidator = artistValidator;
    }

    @InitBinder("track")
    void initTrackBinder(WebDataBinder binder) {
        binder.addValidators(trackValidator);
    }

    @InitBinder("artistDTO")
    void initArtistBinder(WebDataBinder binder) {
        binder.addValidators(artistValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Błąd: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Błąd serwera: " + ex.getMessage());
    }
}
