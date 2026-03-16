package music.web;

import music.model.Track;
import music.service.TrackService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TrackValidator implements Validator {

    private final TrackService trackService;

    public TrackValidator(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Track.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Track validatedTrack = (Track) target;

        boolean duplicated = trackService.getAllTracks().stream()
                .anyMatch(track -> track.getTitle().equalsIgnoreCase(validatedTrack.getTitle()));

        if (duplicated) {
            errors.rejectValue("title", "track.title.duplicated");
        }
    }
}
