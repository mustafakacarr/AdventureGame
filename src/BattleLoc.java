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
        System.out.println("Şu an " + this.getName() + "'dasınız. Dikkat et burada " + this.generateRandObstacle() + " tane " + this.obstacle.getName() + " yaşıyor.");
        System.out.println("<S>avaş veya <K>aç");
        String selectAction=keyboard.nextLine();
        if(selectAction.equalsIgnoreCase("S")){
            System.out.println("savaşma metotları");
        }
        return true;
    }

    public int generateRandObstacle(){
        Random random= new Random();
        return random.nextInt(getMaxObstacle())+1;
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
