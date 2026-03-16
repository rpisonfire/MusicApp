package music.web.ui;

import lombok.RequiredArgsConstructor;
import music.service.PlaylistService;
import music.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;
    private final PlaylistService playlistService;

    @GetMapping("/tracks")
    public String getTracks(
            @RequestParam(required = false) Integer artistId,
            @RequestParam(required = false) Integer playlistId,
            Model model) {

        if (artistId != null) {
            model.addAttribute("tracks", trackService.getTracksByArtist(trackService.getArtistById(artistId)));
        } else if (playlistId != null) {
            model.addAttribute("tracks", playlistService.getPlaylistById(playlistId).getTracks());
        } else {
            model.addAttribute("tracks", trackService.getAllTracks());
        }
        model.addAttribute("title", "Tracks");
        return "tracksView";
    }
}
