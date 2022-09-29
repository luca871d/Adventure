import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public boolean move (char direction){
        Room requestedRoom = null;
        switch (direction){
            case 'n' -> {
                requestedRoom = currentRoom.getN();
            }
            case 'e' -> {
                requestedRoom = currentRoom.getE();
            }
            case 'w' -> {
                requestedRoom = currentRoom.getW();
            }
            case 's' -> {
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }
}
