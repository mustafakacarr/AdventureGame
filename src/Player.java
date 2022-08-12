import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner keyboard = new Scanner(System.in);


    public Player(String name) {
        this.setName(name);
    }


    public void selectChar() {
        Character[] characters = new Character[]{new Samurai(), new Archer(), new Knight()};

        System.out.println("Lütfen Karakter Seçiniz");
        System.out.println("---------------------------------------------");
        for (Character character : characters) {
            System.out.println(character.getId() + "-) " +
                      character.getName() + " " +
                    "\t\t Hasar: " + character.getDamage() + " " +
                    "\t\t Sağlık: " + character.getHealth() + " " +
                    "\t\t Para: " + character.getMoney());
        }
        System.out.println("---------------------------------------------");
        int selectedChar = keyboard.nextInt();
        initCharacter(characters[selectedChar - 1]);
        System.out.println("Seçtiğiniz karakter:  "+
                 this.getCharName() + " " +
                "\t\t Hasar: " + this.getDamage() + " " +
                "\t\t Sağlık: " + this.getHealth() + " " +
                "\t\t Para: " + this.getMoney());
    }

    public void initCharacter(Character character) {
        setCharName(character.getName());
        setDamage(character.getDamage());
        setHealth(character.getHealth());
        setMoney(character.getMoney());

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
