package dungeons.dudes;

public class WeaponAttack implements Effect {
    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.health -= 1;
        System.out.println("Attacked with sword, lose 1hp!");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
    }

    @Override
    public int requiredActionPoints() {
        return 1;
    }

    @Override
    public boolean isExpired() {
        return true;
    }
}
