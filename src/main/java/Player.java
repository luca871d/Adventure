import java.util.ArrayList;

public class Player {
    private Room currentRoom;

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
                currentRoom.removeItem(index);
                itemFound = true;
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
}
