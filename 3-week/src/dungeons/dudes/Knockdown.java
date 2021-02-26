package dungeons.dudes;

public class Knockdown implements Effect{
    @Override
    public void onHit(Dude effectTarget) {

    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

    }

    @Override
    public int requiredActionPoints() {
        return 0;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
