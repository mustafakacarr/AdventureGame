import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    protected static Scanner keyboard = new Scanner(System.in);


    public Location(Player player, String name) {
        this.setPlayer(player);
        this.setName(name);
    }

    abstract boolean onLocation();


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
