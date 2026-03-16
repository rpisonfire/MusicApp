package music.web;

import music.service.TrackService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ArtistValidator implements Validator {

    private final TrackService trackService;

    public ArtistValidator(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ArtistDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ArtistDTO artistDTO = (ArtistDTO) target;

        boolean duplicated = trackService.getAllArtists().stream()
                .anyMatch(a -> a.getFirstName().equalsIgnoreCase(artistDTO.getFirstName())
                        && a.getLastName().equalsIgnoreCase(artistDTO.getLastName()));

        if (duplicated) {
            errors.rejectValue("firstName", "artist.duplicated");
        }
    }
}
