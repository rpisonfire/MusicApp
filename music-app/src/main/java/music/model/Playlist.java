package music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private int id;
    private String name;
    private String logoUrl;
    @JsonIgnore
    private List<Track> tracks = new ArrayList<>();

    public Playlist(int id, String name, String logoUrl) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public Playlist() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
    public List<Track> getTracks() { return tracks; }
    public void setTracks(List<Track> tracks) { this.tracks = tracks; }
    public void addTrack(Track t) { this.tracks.add(t); }

    @Override
    public String toString() {
        return "Playlist{name='" + name + "', logoUrl='" + logoUrl + "'}";
    }
}
