public class SafeHouse extends NormalLoc{

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Sağlığınız yenilendi.");
        return true;
    }
}
