package ai.muse.artistsong.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findSongsByName(String songName);
    Optional<Song> findSongsByArtist(String artistName);
}
