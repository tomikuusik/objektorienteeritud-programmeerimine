package dungeons.dudes;

public class Knockdown implements Effect{
    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.actionPoints = 0;
        System.out.println("Attacked with knockdown, enemy action points reduced to 0!");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

    }

    @Override
    public int requiredActionPoints() {
        return 8;
    }

    @Override
    public boolean isExpired() {
        return true;
    }
}
