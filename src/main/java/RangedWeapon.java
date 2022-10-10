public class RangedWeapon extends Weapon{
    private int ammo;
    public RangedWeapon (String name, String shortName, int ammo) {
        super(name,shortName);
        this.ammo = ammo;
    }

    public boolean canUse() {
        return (ammo > 0);
    }

    public int getAmmo() {
        return ammo;
    }

    public void use(){
        ammo -= 1;
    }
}
