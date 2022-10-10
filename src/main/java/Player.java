import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int health = 10; //Start health
    private Item equippedWeapon;

    public boolean move (PlayerChoice direction){
        Room requestedRoom = null;
        switch (direction){
            case NORTH -> {
                requestedRoom = currentRoom.getN();
            }
            case EAST -> {
                requestedRoom = currentRoom.getE();
            }
            case WEST -> {
                requestedRoom = currentRoom.getW();
            }
            case SOUTH -> {
                requestedRoom = currentRoom.getS();
            }
        }
        if (requestedRoom == null){
            return false;
        }
        else {
            currentRoom = requestedRoom;
            return true;
        }
    }

    public boolean takeItem(String requestedItem){
        boolean itemFound = false;
        ArrayList<Item> itemsInRoom = currentRoom.getItems();
        for (Item item: itemsInRoom){
            if (item.getShortName().equals(requestedItem.toLowerCase())){
                int index = itemsInRoom.indexOf(item);
                inventory.add(item);
                currentRoom.removeItem(index);
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }

    public boolean dropItem(String requestedItem){
        boolean itemFound = false;
        for (Item item: inventory){
            if (item.getShortName().equals(requestedItem.toLowerCase())){
                int index = inventory.indexOf(item);
                currentRoom.addItem(inventory.get(index));
                inventory.remove(index);
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }

    public Usable eatFood(String requestedItem){
        Usable canEat = Usable.NOITEM;
        ArrayList<Item> itemsInRoom = currentRoom.getItems();
        for (Item item: itemsInRoom){
            if (item.getShortName().equals(requestedItem.toLowerCase())){
                if (item instanceof Food){
                    canEat = Usable.USABLE;
                    health += ((Food) item).getHealthEffect();
                    currentRoom.removeItem(itemsInRoom.indexOf(item));
                }
                else{
                    canEat = Usable.HASITEM;
                }
                break;
            }
        }
        if (canEat == Usable.NOITEM){
            for (Item item: inventory){
                if (item.getShortName().equals(requestedItem.toLowerCase())){
                    if (item instanceof Food) {
                        canEat = Usable.USABLE;
                        health += ((Food) item).getHealthEffect();
                        inventory.remove(item);
                    } else {
                        canEat = Usable.HASITEM;
                    }
                    break;
                }
            }
        }
        return canEat;
    }
    public Usable equip(String requestedItem){
        Usable canEquip = Usable.NOITEM;
        for (Item item: inventory){
            if (item.getShortName().equals(requestedItem.toLowerCase())){
                if (item instanceof Weapon) {
                    canEquip = Usable.USABLE;
                    equippedWeapon = item;
                    }
                else {
                    canEquip = Usable.HASITEM;
                }
                break;
            }
        }
        return canEquip;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public int getHealth() {
        return health;
    }
}
