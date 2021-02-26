package dungeons.dudes;

public class Spiderweb implements Effect{
    int usesBeforeExiry;
    @Override
    public void onHit(Dude effectTarget) {
        this.usesBeforeExiry += 2;
        effectTarget.currentlyActiveEffects.add(this);
        System.out.println("Attacked with spiderweb, lose 2 actionpoints for 2 turns!");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        effectTarget.actionPoints -= 4;
        System.out.println("Spiderweb removed 2 action points!");
        usesBeforeExiry -= 1;
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
    }

    @Override
    public int requiredActionPoints() {
        return 6;
    }

    @Override
    public boolean isExpired() {
        if (this.usesBeforeExiry <= 0) {
            return true;
        }
        return false;
    }
}
