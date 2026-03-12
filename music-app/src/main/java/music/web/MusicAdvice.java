package music.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MusicAdvice {

    private final TrackValidator trackValidator;

    public MusicAdvice(TrackValidator trackValidator) {
        this.trackValidator = trackValidator;
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(trackValidator);
    }
}
