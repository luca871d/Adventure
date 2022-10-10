abstract public class Weapon extends Item {
    public Weapon (String name, String shortName){
        super(name, shortName);
    }

    abstract public boolean canUse();
    abstract public int getAmmo();
    abstract public void use();
}
