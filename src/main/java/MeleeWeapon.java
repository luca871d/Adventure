public class MeleeWeapon extends Weapon{
    public MeleeWeapon (String name, String shortName, int damage) {
        super(name,shortName,damage);
    }

    public boolean canUse() {
        return true;
    }

    public void use(){

    }
}
