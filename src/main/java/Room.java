import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room n;
    private Room e;
    private Room w;
    private Room s;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public Room (String name, String description, Room n, Room e, Room w, Room s){
        this.name = name;
        this.description = description;
        this.n = n;
        this.e = e;
        this.w = w;
        this.s = s;
    }

    public String[] lookAround(){
        String[] roomDetails = new String[items.size() + 2];
        roomDetails[0] = name;
        roomDetails[1] = description;
        int i = 0;
        for (Item item: items){
            roomDetails[i+2] = items.get(i).getName();
            i++;
        }
        return roomDetails;
    }
    public String[] lookAtEnemies(){
        String[] roomDetails = new String[enemies.size() * 2];
        int i = 0;
        for (int j = 0; j < enemies.size() * 2 - 1; j++){
            roomDetails[i] = enemies.get(j).getName();
            i++;
            roomDetails[i] = enemies.get(j).getDesc();
            i++;
        }
        return roomDetails;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public void setN (Room room){
        n = room;
    }
    public void setE (Room room){
        e = room;
    }
    public void setW (Room room){
        w = room;
    }
    public void setS (Room room){
        s = room;
    }

    public Room getN() {
        return n;
    }

    public Room getE() {
        return e;
    }

    public Room getW() {
        return w;
    }

    public Room getS() {
        return s;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public boolean isEnemy (){
        return !enemies.isEmpty();
    }

    public Enemy getEnemy(){
        return enemies.get(0);
    }

    public void deadEnemy(){
        items.add(enemies.get(0).getWeapon());
        enemies.remove(0);
    }
}
