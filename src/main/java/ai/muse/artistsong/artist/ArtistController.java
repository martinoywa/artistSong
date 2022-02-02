package ai.muse.artistsong.artist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v2/artist")
public class ArtistController {

    public final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @PutMapping(value = "{id}")
    public void updateArtistDoB(@PathVariable("id") Long id,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) {
        artistService.updateArtistDoB(id, dob);
    }

}
