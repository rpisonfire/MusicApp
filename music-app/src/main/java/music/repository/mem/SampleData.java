package music.repository.mem;

import music.model.Artist;
import music.model.Playlist;
import music.model.Track;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static List<Artist> artists = new ArrayList<>();
    public static List<Track> tracks = new ArrayList<>();
    public static List<Playlist> playlists = new ArrayList<>();

    static {
        Artist a1 = new Artist(1, "Kendrick", "Lamar");
        Artist a2 = new Artist(2, "Travis", "Scott");
        Artist a3 = new Artist(3, "The", "Weeknd");
        artists.add(a1); artists.add(a2); artists.add(a3);

        Track t1 = new Track(1, "Not Like Us",     "https://covers.example.com/nlu.jpg",    a1, 9.5f);
        Track t2 = new Track(2, "FE!N",            "https://covers.example.com/fein.jpg",   a2, 9.0f);
        Track t3 = new Track(3, "Blinding Lights", "https://covers.example.com/bl.jpg",     a3, 9.8f);
        Track t4 = new Track(4, "Humble",          "https://covers.example.com/humble.jpg", a1, 9.3f);
        tracks.add(t1); tracks.add(t2); tracks.add(t3); tracks.add(t4);

        a1.addTrack(t1); a1.addTrack(t4);
        a2.addTrack(t2);
        a3.addTrack(t3);

        Playlist p1 = new Playlist(1, "Rap Bangers",   "https://logos.example.com/rap.jpg");
        Playlist p2 = new Playlist(2, "Polskie Tango",   "https://logos.example.com/pltango.jpg");
        Playlist p3 = new Playlist(3, "Top Hits 2025", "https://logos.example.com/top.jpg");
        Playlist p4 = new Playlist(4, "Back in 80's", "https://logos.example.com/80s.jpg");

        p1.addTrack(t1); p1.addTrack(t2); p1.addTrack(t4);
        p2.addTrack(t3); p2.addTrack(t2);
        p3.addTrack(t1); p3.addTrack(t3);

        t1.addPlaylist(p1); t1.addPlaylist(p3);
        t2.addPlaylist(p1); t2.addPlaylist(p2);
        t3.addPlaylist(p2); t3.addPlaylist(p3);
        t4.addPlaylist(p1);

        playlists.add(p1); playlists.add(p2); playlists.add(p3); playlists.add(p4);
    }
}
