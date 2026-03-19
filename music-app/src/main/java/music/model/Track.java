package music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "cover_url")
    private String coverUrl;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "rating")
    private float rating;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "track_playlist",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    private List<Playlist> playlists = new ArrayList<>();

    public Track(int id, String title, String coverUrl, Artist artist, float rating) {
        this.id = id;
        this.title = title;
        this.coverUrl = coverUrl;
        this.artist = artist;
        this.rating = rating;
    }

    public Track() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public List<Playlist> getPlaylists() { return playlists; }
    public void setPlaylists(List<Playlist> playlists) { this.playlists = playlists; }
    public void addPlaylist(Playlist p) { this.playlists.add(p); }

    @Override
    public String toString() {
        return "Track{title='" + title + "', artist=" + artist + ", rating=" + rating + "}";
    }
}
