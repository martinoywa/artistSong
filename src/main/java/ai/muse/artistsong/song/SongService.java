package ai.muse.artistsong.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
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
    }
}
