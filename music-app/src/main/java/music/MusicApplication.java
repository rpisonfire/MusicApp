package music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// zastępuje nasz AnnotationConfigApplicationContext("music") z MusicServiceMain
public class MusicApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(MusicApplication.class, args);
    }
}
