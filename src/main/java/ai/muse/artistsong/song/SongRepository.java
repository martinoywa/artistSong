package ai.muse.artistsong.song;

import ai.muse.artistsong.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findSongsByName(String songName);
    Optional<Song> findSongsByArtist(String artistName);
    List<Song> findAllByArtist(String artistName);
}
