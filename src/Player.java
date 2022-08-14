import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner keyboard = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.setName(name);
        this.setInventory(new Inventory());
    }

    public void printInfo() {
        System.out.println("Silahınız : " + getInventory().getWeapon().getName() +
                " \t\t Hasarınız: " + getDamage() +
                "\t\t Zırhınız: " + getInventory().getArmor().getName() +
                "\t\t Zırh Koruması: " + getInventory().getArmor().getBlock() +
                "\t\t Paranız: " + getMoney() +
                " \t\t Sağlığınız: " + getHealth());
    }

    public void selectChar() {
        Character[] characters = new Character[]{new Samurai(), new Archer(), new Knight()};

        System.out.println("Lütfen Seçmek İstediğiniz Karakterin ID'sini yazınız.");
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
        System.out.println("Seçtiğiniz karakter:  " +
                this.getCharName() + " " +
                "\t\t Hasar: " + this.getDamage() + " " +
                "\t\t Sağlık: " + this.getHealth() + " " +
                "\t\t Para: " + this.getMoney());
    }

    public boolean selectLocation() {
        Location[] locations = new Location[]{new SafeHouse(this), new ToolStore(this)};
        System.out.println("Bölgeler");
        System.out.println("1-) Güvenli Ev -> Burası güvenlidir, düşman giremez.");
        System.out.println("2-) Mağaza -> Buradan silah veya zırh satın alabilirsiniz.");
        System.out.println("3-) Oyunu Bitir");
        System.out.println("Lütfen gitmek istediğiniz lokasyonun ID'sini yazınız.");
        int selectedLoc = keyboard.nextInt();
        if (selectedLoc != 3) {
            return locations[selectedLoc - 1].onLocation();

        }else {
            System.out.println("Oyun Bitti!");
            return false;
        }

    }

    public void initCharacter(Character character) {
        setCharName(character.getName());
        setDamage(character.getDamage());
        setHealth(character.getHealth());
        setMoney(character.getMoney());

    }

    public int getDamage() {
        return damage + getInventory().getWeapon().getDamage();
        //Bu sayede bir kullanıcı aynı silahtan birden fazla alsa bile hasarı artmıyor.
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
