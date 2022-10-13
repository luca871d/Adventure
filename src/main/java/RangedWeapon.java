public class RangedWeapon extends Weapon{
    private int ammo;
    public RangedWeapon (String name, String shortName, int damage, int ammo) {
        super(name,shortName,damage);
        this.ammo = ammo;
    }

    public boolean canUse() {
        return (ammo > 0);
    }

    public void use(){
        ammo -= 1;
    }
}
