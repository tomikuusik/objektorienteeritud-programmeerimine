package dungeons.dudes;

public interface Effect {
    void onHit(Dude effectTarget);
    void onTurnStart(Dude effectTarget);
    void onTurnEnd(Dude effectTarget);
    int requiredActionPoints();
    boolean isExpired();
}
