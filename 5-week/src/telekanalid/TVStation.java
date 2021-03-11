package telekanalid;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TVStation extends Broadcaster{
    private List<String> news;
    public TVStation(List<String> news) {
        this.news = news;
    }

    /**
     * Meetod edastab superclassi meetodi kasutades uudiste listist suvalise uudise
     */
    public void sendNews() {
        broadcast(news.get(ThreadLocalRandom.current().nextInt(news.size())));
    }
}
