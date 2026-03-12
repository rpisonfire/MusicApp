package music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {

    @Bean
    public String appName() {
        return "MusicStreamingApp v1.0";
    }
}
