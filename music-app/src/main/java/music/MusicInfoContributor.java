package music;

import music.repository.TrackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MusicInfoContributor implements InfoContributor {

    @Autowired
    private TrackDao trackDao;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("tracks", trackDao.findAll().size());
    }
}
