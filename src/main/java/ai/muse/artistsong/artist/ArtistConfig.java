package ai.muse.artistsong.artist;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class ArtistConfig {

    @Bean
    CommandLineRunner commandLineRunnerArtist(ArtistRepository artistRepository) {
        return args -> {
            artistRepository.save(
                    new Artist(
                            1L,
                            "Halsey",
                            LocalDate.of(1994, Month.SEPTEMBER, 29),
                            100L
                    )
            );
        };
    }

}
