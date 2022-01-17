package ai.muse.artistsong.song;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class SongConfig {

    @Bean
    CommandLineRunner commandLineRunner(SongRepository songRepository) {
        return args -> {
            Song withoutMe = new Song(
                    "Without Me",
                    "Halsey",
                    "Manic",
                    LocalDate.of(2018, OCTOBER, 4)
            );

            Song noRightToLoveYou = new Song(
                    "No Right To Love You",
                    "Rhys Lewis",
                    "Things I Chose To Remember",
                    LocalDate.of(2020, MAY, 18)
            );

            songRepository.saveAll(
                    List.of(withoutMe, noRightToLoveYou)
            );
        };
    }
}
