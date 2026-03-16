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
        // Artyści
        Artist a1 = new Artist(1, "Kendrick", "Lamar");
        Artist a2 = new Artist(2, "Travis", "Scott");
        Artist a3 = new Artist(3, "The", "Weeknd");
        Artist a4 = new Artist(4, "Taco", "Hemingway");
        artists.add(a1); artists.add(a2); artists.add(a3); artists.add(a4);

        // Oryginalne tracki
        Track t1 = new Track(1, "Not Like Us",     "https://covers.example.com/nlu.jpg",    a1, 9.5f);
        Track t2 = new Track(2, "FE!N",            "https://covers.example.com/fein.jpg",   a2, 9.0f);
        Track t3 = new Track(3, "Blinding Lights", "https://covers.example.com/bl.jpg",     a3, 9.8f);
        Track t4 = new Track(4, "Humble",          "https://covers.example.com/humble.jpg", a1, 9.3f);
        Track t5 = new Track(5, "DNA",               "https://covers.example.com/dna.jpg",    a1, 9.1f);
        Track t6 = new Track(6, "ADHD",              "https://covers.example.com/adhd.jpg",   a1, 8.8f);
        Track t7 = new Track(7, "Café Belga",        "https://covers.example.com/cafe.jpg",   a4, 9.0f);
        Track t8 = new Track(8, "Trójkąt Warszawski","https://covers.example.com/trojkat.jpg",a4, 8.7f);
        Track t9 = new Track(9, "Dym",               "https://covers.example.com/dym.jpg",   a4, 8.5f);

        tracks.add(t1); tracks.add(t2); tracks.add(t3); tracks.add(t4);
        tracks.add(t5); tracks.add(t6); tracks.add(t7); tracks.add(t8); tracks.add(t9);

        a1.addTrack(t1); a1.addTrack(t4); a1.addTrack(t5); a1.addTrack(t6);
        a2.addTrack(t2);
        a3.addTrack(t3);
        a4.addTrack(t7); a4.addTrack(t8); a4.addTrack(t9);

        Playlist p1 = new Playlist(1, "Rap Bangers",    "https://logos.example.com/rap.jpg");
        Playlist p2 = new Playlist(2, "Polskie Tango",  "https://logos.example.com/pltango.jpg");
        Playlist p3 = new Playlist(3, "Top Hits 2025",  "https://logos.example.com/top.jpg");
        Playlist p4 = new Playlist(4, "Back in 80's",   "https://logos.example.com/80s.jpg");
        Playlist p5 = new Playlist(5, "Kendrick Only",  "https://logos.example.com/kdot.jpg");

        p1.addTrack(t1); p1.addTrack(t2); p1.addTrack(t4);
        p2.addTrack(t7); p2.addTrack(t8); p2.addTrack(t9);
        p3.addTrack(t1); p3.addTrack(t3);
        p5.addTrack(t1); p5.addTrack(t4);

        t1.addPlaylist(p1); t1.addPlaylist(p3); t1.addPlaylist(p5);
        t2.addPlaylist(p1);
        t3.addPlaylist(p3);
        t4.addPlaylist(p1); t4.addPlaylist(p5);
        t7.addPlaylist(p2);
        t8.addPlaylist(p2);
        t9.addPlaylist(p2);

        playlists.add(p1); playlists.add(p2); playlists.add(p3);
        playlists.add(p4); playlists.add(p5);
    }
}
