import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.setMaxObstacle(maxObstacle);
        this.setObstacle(obstacle);
        this.setAward(award);
    }

    @Override
    boolean onLocation() {
        int obstNumber = this.generateRandObstacle();
        System.out.println("Şu an " + this.getName() + "'dasınız. Dikkat et burada " + obstNumber + " tane " + this.obstacle.getName() + " yaşıyor.");
        System.out.println("<S>avaş veya <K>aç");
        String selectAction = keyboard.nextLine();
        if (selectAction.equalsIgnoreCase("S")) {
            if (combat(obstNumber)) {
                System.out.println("Kazandınız. Ödülünüz hesabınıza tanımlandı");
                getPlayer().setMoney(getObstacle().getAward());
                playerStats();
                return true;
            }

        }
        if (getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int obstNumber) {
        int obstDefaultHealth = this.getObstacle().getHealth();
        for (int i = 1; i <= obstNumber; i++) {
            System.out.println(i + ". Canavar ile savaşıyorsun.");
            playerStats();
            obstStats();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>UR VEYA <K>AÇ");
                String action = keyboard.nextLine();
                if (action.equalsIgnoreCase("V")) {
                    System.out.println("Vurdunuz.");
                    getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
                    if (getObstacle().getHealth() > 0) {
                        System.out.println("Canavar vurdu.");
                        int obstDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
                        if (obstDamage < 0) {
                            obstDamage = 0;
                        }
                        getPlayer().setHealth(getPlayer().getHealth() - obstDamage);
                    }
                    playerStats();
                    obstStats();
                } else {

                    System.out.println("Kaçan kovalanır.");
                    return false;

                }
            }

            getObstacle().setHealth(obstDefaultHealth);
        }
        return true;
    }

    public void playerStats() {
        System.out.println("\t\t Hasar: " + getPlayer().getDamage() + " " +
                "\t\t Sağlık: " + getPlayer().getHealth() + " " +
                "\t\t Para: " + getPlayer().getMoney() +
                "\t\t Silah: " + getPlayer().getInventory().getWeapon().getName() +
                "\t\t Zırh: " + getPlayer().getInventory().getArmor().getName() +
                "\t\t Bloklama: " + getPlayer().getInventory().getArmor().getBlock());
    }

    public void obstStats() {
        System.out.println(getObstacle().getName() + " Canavarına Ait Detaylar");
        System.out.println("\t\t Hasar: " + getObstacle().getDamage() +
                "\t\t Sağlık: " + getObstacle().getHealth() +
                "\t\t Ödülü: " + getObstacle().getAward());
    }

    public int generateRandObstacle() {
        Random random = new Random();
        return random.nextInt(getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
