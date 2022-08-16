public class Obstacle  {
    private int id;
    private int health;
    private int damage;
    private String name;
    private int award;
    //   private int maxObstacle;


    public Obstacle(int id, int health, int damage, String name,int award) {
        this.setId(id);
        this.setHealth(health);
        this.setDamage(damage);
        this.setName(name);
        this.setAward(award);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
