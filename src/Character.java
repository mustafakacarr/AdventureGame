public abstract class Character {
    private String name;
    private int damage;
    private int health;
    private int money;
    private int id;

    public Character(int id, String name, int damage, int health, int money) {
        this.setId(id);
        this.setName(name);
        this.setDamage(damage);
        this.setHealth(health);
        this.setMoney(money);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
