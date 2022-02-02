package ai.muse.artistsong;

import ai.muse.artistsong.artist.Artist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class ArtistSongApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtistSongApplication.class, args);
    }

}
