
package music.service;

import music.model.Playlist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MusicServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find playlists!");

        // Tworzymy kontekst Springa - skanuje cały pakiet "music" i automatycznie tworzy beany z adnotacjami @Component
        ApplicationContext context = new AnnotationConfigApplicationContext("music");

        // Pobieramy bean z kontekstu po typie interfejsowym
        PlaylistService service = context.getBean(PlaylistService.class);
        String appName = context.getBean("appName", String.class);

        //PlaylistService service2 = context.getBean(PlaylistService.class);
        //System.out.println(service == service2); // false = prototype działa

        System.out.println("App: " + appName);           //info z music.config (nazwa apki)

        // Używamy serwisu normalnie
        List<Playlist> playlists = service.getAllPlaylists();
        System.out.println(playlists.size() + " playlists found:");
        playlists.forEach(System.out::println);
    }
}

