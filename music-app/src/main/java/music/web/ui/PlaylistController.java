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
public class PlaylistController {

    private final PlaylistService playlistService;
    private final TrackService trackService;

    @GetMapping("/playlists")
    public String getPlaylists(@RequestParam(required = false) Integer trackId, Model model) {
        if (trackId != null) {
            model.addAttribute("playlists", trackService.getTrackById(trackId).getPlaylists());
        } else {
            model.addAttribute("playlists", playlistService.getAllPlaylists());
        }
        model.addAttribute("title", "Playlists");
        return "playlistsView";
    }
}
