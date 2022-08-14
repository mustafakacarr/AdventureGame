public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory(){
        this.setWeapon(new Weapon(0,0,0,"Yumruk"));
        this.setArmor(new Armor(0,"Zırh Yok",0,0));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
