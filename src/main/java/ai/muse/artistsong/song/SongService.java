package ai.muse.artistsong.song;

import ai.muse.artistsong.artist.Artist;
import ai.muse.artistsong.artist.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    @Autowired
    public SongService(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public void addNewSong(Song song) {
        Optional<Song> songName = songRepository.findSongsByName(song.getName());
        Optional<Song> artistName = songRepository.findSongsByArtist(song.getArtist());
        if (songName.isPresent() && artistName.isPresent()) {
            throw new IllegalStateException("Song " + song.getName() + " by " + song.getArtist() + " already exists");
        }
        songRepository.save(song);

        Artist artist = artistRepository.findArtistByArtistName(song.getArtist())
                .orElseThrow(() ->  new IllegalStateException("Song not present"));
//                .orElse(artistRepository.save(
//                        new Artist(
//                                song.getArtist(),
//                                null,
//                                0L
//                        )
//                ));

        if (artist.getId() != null) {
            artist.setNumberOfTitles(artist.getNumberOfTitles()+1);
        }
    }

    public void removeSong(Long id) {
        if (!songRepository.existsById(id)) {
            throw new IllegalStateException("Song by id " + id + " not present");
        }
        songRepository.deleteById(id);
    }

    @Transactional
    public void updateSongDetails(Long id, String album, LocalDate release) {
        Song song = songRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException("Song by id " + id + " not present"));

        if (album != null && album.length() > 0 && !Objects.equals(song.getAlbum(), album)) {
            song.setAlbum(album);
        }

        if (release != null && song.getRelease() != release) {
            song.setRelease(release);
        }
    }
}
