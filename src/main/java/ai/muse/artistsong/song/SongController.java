package ai.muse.artistsong.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping
    public void addNewSong(@RequestBody Song song) {
        songService.addNewSong(song);
    }

    @DeleteMapping(value = "{id}")
    public void removeSong(@PathVariable("id") Long id) {
        songService.removeSong(id);
    }

    @PutMapping(value = "{id}")
    public void updateSongDetails(@PathVariable("id") Long id,
                                  @RequestParam(required = false) String album,
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate release) {
        songService.updateSongDetails(id, album, release);
    }

}
