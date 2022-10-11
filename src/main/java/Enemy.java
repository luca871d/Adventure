public class Enemy {
    private Weapon weapon;
    private int health;

    public Enemy (Weapon weapon, int health){
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
}
