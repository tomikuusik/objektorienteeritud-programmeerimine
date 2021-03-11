package telekanalid;

public class PirateStation extends Broadcaster implements BroadcastListener{
    @Override
    public void listen(String transmission) {
        broadcast(transmission);
    }
}
