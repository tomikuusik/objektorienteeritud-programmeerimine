package telekanalid;

import java.util.ArrayList;
import java.util.List;

public class Broadcaster {
    private List<BroadcastListener> subscribers = new ArrayList<>();
    /**
     * Meetod jätab meelde kõik BroadcastListenerid kes seda broadcasti tellivad
     * @param subscriber  telekanalid.BroadcastListener object kes soovib broadcasti tellida
     */
    void subscribe(BroadcastListener subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Meetod edastab kõigile telekanalid.Broadcaster klassi isendi tellijatele mingi sõnumi
     * @param content String mida soovitakse tellijatele edastada
     */
    void broadcast (String content) {
        for (BroadcastListener subscriber : subscribers) {
            subscriber.listen(content);
        }
    }
}
