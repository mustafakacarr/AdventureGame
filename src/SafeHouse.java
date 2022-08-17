public class SafeHouse extends NormalLoc{

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        getPlayer().setHealth(getPlayer().getDefaultHealth());
        System.out.println("Güvenli evdesiniz. Sağlığınız yenilendi.");
        System.out.println("Sağlığınız: "+ getPlayer().getHealth());
        return true;
    }
}
