package dungeons.dudes;

public class Fighter extends Dude{
    Fighter(String name) {
        this.accuracy = 4;
        this.health = 40;
        this.actionPoints = 14;
        this.armor = 30;
        this.name = name;
    }
    @Override
    Effect chooseEffect() {
        if (this.actionPoints > 8) {
            return new Knockdown();
        }
        else {
            return new WeaponAttack();
        }
    }
    void resetActionPoints(){
        this.actionPoints = 12;
    }
}