package dungeons.dudes;

public class Main {
    public static void main(String[] args) {
        Dude Kalle = new Fighter("Kalle");
        Dude Henri = new Wizard("Henri");
        int roundCounter = 1;
        while(Henri.isAlive() && Kalle.isAlive()) {
            System.out.println("\n\n----- Start of round " + roundCounter + " -----" );
            Henri.takeTurn(Kalle);
            Kalle.takeTurn(Henri);
            roundCounter += 1;
        }

        System.out.println("\n" + "-".repeat(20));
        System.out.println("END STATISTICS");
        System.out.println("Game went on for " + roundCounter + " rounds");
        Henri.getStats();
        Kalle.getStats();
        System.out.println("-".repeat(20));
    }
}
