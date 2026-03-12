package music;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import jakarta.annotation.PostConstruct;
import music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MusicComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final TrackService trackService;

    public MusicComponent(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostConstruct
    public void init() {
        log.info("=== 1. @PostConstruct ===");
        trackService.getAllTracks().forEach(track -> log.info("{}", track));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("=== 2. CommandLineRunner.run ===");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("=== 3. ApplicationListener.onApplicationEvent ===");
    }
}
