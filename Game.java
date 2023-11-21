public class Game {
    public static void main(String[] args) {
        Player knight = new Player("Knight");
        Player archer = new Player("Archer");
        Player wizard = new Player("Wizard");
        new PlayerObserver(archer);
        new PlayerObserver(knight);
        new PlayerObserver(wizard);
        
        
        archer.attack();
        knight.attack();
        wizard.attack();
    }
}
