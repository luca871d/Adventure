public class Enemy {
    private String name;
    private String desc;
    private Weapon weapon;
    private int health;

    public Enemy (String name, String desc, Weapon weapon, int health){
        this.name = name;
        this.desc = desc;
        this.weapon = weapon;
        this.health = health;
    }

    public boolean hit (int damage){
        health -= damage;
        if (health <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public int attack(){
        return weapon.getDamage();
    }

    public Item getWeapon(){
        return (Item) weapon;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
