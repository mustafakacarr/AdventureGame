public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz.");
        System.out.println("1-) Silah");
        System.out.println("2-) Zırh");
        System.out.println("3-) Mağazadan Çıkış Yap");
        System.out.println("Yapmak istediğiniz işlemin ID'sini yazınız.");
        int selectedAction = Location.keyboard.nextInt();
        while (selectedAction > 3 || selectedAction < 1) {
            System.out.println("Geçersiz değer girdiniz, tekrar işlem seçiniz.");
            System.out.println("Yapmak istediğiniz işlemin ID'sini yazınız.");
            selectedAction = Location.keyboard.nextInt();
        }
        switch (selectedAction) {
            case 1:
                showWeapons();
                break;
            case 2:
                showArmors();
                break;
            case 3:
                System.out.println("Tekrar bekleriz.");
                return true;
        }
        return true;
    }

    public void showWeapons() {
        Weapon[] weapons = new Weapon[]{new Gun(), new Sword(), new Rifle()};
        System.out.println("Silahlar");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getId() + "-) " + weapon.getName() + "\t\t Hasar: " + weapon.getDamage() + "\t\t Ücret: " + weapon.getPrice());
        }
        System.out.println("Satın almak istediğiniz silahın ID'sini yazınız.");
        System.out.println("Çıkış yapmak için 0 yazınız.");

        int selected = Location.keyboard.nextInt();
        if (selected != 0) {
            buyWeapon(weapons[selected - 1]);

        } else {
            showMenu();
        }

    }

    private void showMenu() {
        onLocation();
    }

    public void showArmors() {
        Armor[] armors = new Armor[]{new LightArmor(), new MidArmor(), new HeavyArmor()};
        System.out.println("Zırhlar");
        for (Armor armor : armors) {
            System.out.println(armor.getId() + "-) " + armor.getName() + "\t\t Engelleme: " + armor.getBlock() + "\t\t Ücret: " + armor.getPrice());
        }
        System.out.println("Satın almak istediğiniz zırhın ID'sini yazınız.");
        System.out.println("Çıkış yapmak için 0 yazınız.");

        int selected = Location.keyboard.nextInt();

        if (selected != 0) {
            buyArmor(armors[selected - 1]);
        } else {
            showMenu();
        }

    }

    private void buyArmor(Armor armor) {
        if (getPlayer().getMoney() > armor.getPrice()) {
            getPlayer().setMoney(getPlayer().getMoney() - armor.getPrice());
            getPlayer().getInventory().setArmor(armor);
            System.out.println(armor.getName() + " Başarıyla Satın Alındı.");
            System.out.println("Son durumdaki bilgileriniz;");
            getPlayer().printInfo();

        } else {
            System.out.println("Bu zırhı satın almak için paranız yetersiz.");
        }
    }

    public void buyWeapon(Weapon weapon) {
        if (getPlayer().getMoney() > weapon.getPrice()) {
            getPlayer().setMoney(getPlayer().getMoney() - weapon.getPrice());
            getPlayer().getInventory().setWeapon(weapon);
            System.out.println(weapon.getName() + " Başarıyla Satın Alındı.");
            System.out.println("Son durumdaki bilgileriniz;");
            getPlayer().printInfo();

        } else {
            System.out.println("Bu silahı satın almak için paranız yetersiz.");
        }
    }
}
