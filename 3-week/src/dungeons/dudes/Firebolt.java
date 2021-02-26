package dungeons.dudes;

public class Firebolt implements Effect{
    int usesBeforeExiry;
    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.currentlyActiveEffects.add(this);
        System.out.println("Attacked with firebolt, effect at end of turn applied!");
        this.usesBeforeExiry += 1;
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        effectTarget.health -= 2;
        System.out.println("Firebolt ticked minus 2hp");
        this.usesBeforeExiry -= 1;
    }

    @Override
    public int requiredActionPoints() {
        return 1;
    }

    @Override
    public boolean isExpired() {
        if (usesBeforeExiry <= 0) {
            return true;
        }
        return false;
    }
}
