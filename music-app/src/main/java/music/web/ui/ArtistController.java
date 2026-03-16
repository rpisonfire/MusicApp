package music.web.ui;

import lombok.RequiredArgsConstructor;
import music.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class ArtistController {

    private final TrackService trackService;

    @GetMapping("/artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", trackService.getAllArtists());
        model.addAttribute("title", "Artists");
        return "artistsView";
    }
}
