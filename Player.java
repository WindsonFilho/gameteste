import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers();
}

class Player implements Subject {
    private String playerType;
    private List<Observer> observers = new ArrayList<>();

    public Player(String playerType) {
        this.playerType = playerType;
    }

    public void attack() {
        if (playerType.equals("Knight")) {
            System.out.println("Swing sword");
        } else if (playerType.equals("Archer")) {
            System.out.println("Shoot arrow");
        } else if (playerType.equals("Wizard")) {
            System.out.println("Cast spell");
        }

        notifyObservers();
    }

    public String getPlayerType() {
        return playerType;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class PlayerObserver implements Observer {
    private Player player;

    public PlayerObserver(Player player) {
        this.player = player;
        player.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println( player.getPlayerType() + " has attacked.");
    }
}
