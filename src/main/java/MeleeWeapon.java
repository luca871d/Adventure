public class MeleeWeapon extends Weapon{
    public MeleeWeapon (String name, String shortName) {
        super(name,shortName);
    }

    public boolean canUse() {
        return true;
    }

    public int getAmmo() {
        return -1;
    }

    public void use(){

    }
}
