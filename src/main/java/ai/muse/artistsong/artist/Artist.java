package ai.muse.artistsong.artist;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Artist {

    @Id
    @SequenceGenerator(
            name = "artist_id_sequence",
            sequenceName = "artist_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_id_sequence"
    )
    private Long id;
    private String artistName;
    private LocalDate dob;
    private Long numberOfTitles;

    public Artist() {
    }

    public Artist(Long id, String artistName, LocalDate dob, Long numberOfTitles) {
        this.id = id;
        this.artistName = artistName;
        this.dob = dob;
        this.numberOfTitles = numberOfTitles;
    }

    public Artist(String artistName, LocalDate dob, Long numberOfTitles) {
        this.artistName = artistName;
        this.dob = dob;
        this.numberOfTitles = numberOfTitles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getNumberOfTitles() {
        return numberOfTitles;
    }

    public void setNumberOfTitles(Long numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", dob=" + dob +
                ", numberOfTitles=" + numberOfTitles +
                '}';
    }

}
