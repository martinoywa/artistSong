package ai.muse.artistsong.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    @Transactional
    public void updateArtistDoB(Long id, LocalDate dob) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Artist by id " + id + " not present"));

        if (dob != null && artist.getDob() != dob) {
            artist.setDob(dob);
        }
//        } else {
//            throw new IllegalStateException("The date of birth provided is either empty or same as current");
//        }
    }
}
