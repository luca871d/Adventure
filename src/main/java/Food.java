public class Food extends Item{
    private int healthEffect;
    public Food (String name, String shortName, int healthEffect){
        super(name, shortName);
        this.healthEffect = healthEffect;
    }

    public int getHealthEffect() {
        return healthEffect;
    }
}
