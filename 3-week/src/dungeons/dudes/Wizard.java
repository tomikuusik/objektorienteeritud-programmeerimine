package dungeons.dudes;

public class Wizard extends Dude{
    Wizard(String name) {
        this.accuracy = 22;
        this.health = 23;
        this.actionPoints = 14;
        this.armor = 10;
        this.name = name;
    }
    @Override
    Effect chooseEffect() {
        if (this.actionPoints > 6) {
            return new Spiderweb();
        }
        else {
            return new Firebolt();
        }
    }
    void resetActionPoints(){
        this.actionPoints = 14;
    }
}
