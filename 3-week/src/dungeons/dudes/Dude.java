package dungeons.dudes;

abstract class Dude {
    int accuracy;
    int armor;
    int health;
    int actionPoints;
    void takeTurn(Dude attacktarget) {};
    boolean isAlive() {};
}
