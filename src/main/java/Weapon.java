abstract public class Weapon extends Item {
    private int damage;
    public Weapon (String name, String shortName, int damage){
        super(name, shortName);
        this.damage = damage;
    }

    abstract public boolean canUse();
    abstract public void use();
    public int getDamage(){
        return damage;
    }
}
