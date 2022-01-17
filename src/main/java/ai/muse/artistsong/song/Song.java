package ai.muse.artistsong.song;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Song {

    @Id
    @SequenceGenerator(
            name = "song_id_sequence",
            sequenceName = "song_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_id_sequence"
    )
    private Long id;
    private String name;
    private String artist;
    private String album;
    private LocalDate release;

    public Song() {
    }

    public Song(Long id, String name, String artist, String album, LocalDate release) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.release = release;
    }

    public Song(String name, String artist, String album, LocalDate release) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.release = release;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", release=" + release +
                '}';
    }

}
