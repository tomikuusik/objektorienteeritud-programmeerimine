package telekanalid;

public class TV implements BroadcastListener {
    private String userName;
    public TV(String userName) {
        this.userName = userName;
    }

    @Override
    public void listen(String transimission) {
        System.out.println(transimission + " -> " + userName);
    }
}
