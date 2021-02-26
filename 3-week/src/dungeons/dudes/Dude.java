package dungeons.dudes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

abstract class Dude {
    ArrayList<Effect> currentlyActiveEffects;
    int accuracy;
    int armor;
    int health;
    int actionPoints;
    String name;

    Dude() {
        currentlyActiveEffects = new ArrayList<>();
    }

    void takeTurn(Dude attacktarget) {
        System.out.println("\n- Start of " + this.name + "'s turn with: " + currentlyActiveEffects.size() + " active effects -");
        Iterator<Effect> iterator = currentlyActiveEffects.iterator();
        System.out.println("\n-- Before action effects --");
        while (iterator.hasNext()) {
            Effect effect = iterator.next();
            if (effect.isExpired()) {
                iterator.remove();
            } else {
                effect.onTurnStart(this);
            }
        }
        System.out.println("");
        int turnCounter = 1;
        while (this.actionPoints > 0) {
            System.out.println("--- Action " + turnCounter + " (p: " + this.actionPoints + ", hp: " + this.health + ") --- ");
            Effect chosenEffect = this.chooseEffect();
            this.actionPoints -= chosenEffect.requiredActionPoints();

            Random randomizer = new Random();
            if (randomizer.nextInt(21) + this.accuracy >= attacktarget.armor) {
                chosenEffect.onHit(attacktarget);
            } else {
                System.out.println("Missed!");
            }
            turnCounter += 1;
        }
        iterator = currentlyActiveEffects.iterator();
        System.out.println("\n-- After action effects --");
        while (iterator.hasNext()) {
            Effect effect = iterator.next();
            if (effect.isExpired()) {
                iterator.remove();
            } else {
                effect.onTurnEnd(this);
            }
        }
        this.resetActionPoints();
    };
    boolean isAlive() {
        if (this.health > 0) {
            return true;
        }
        else {
            return false;
        }
    };
    abstract Effect chooseEffect();
    abstract void resetActionPoints();
    void getStats() {
        System.out.println("\nnimi: " + this.name);
        System.out.println("hp: " + this.health);
    }
}
