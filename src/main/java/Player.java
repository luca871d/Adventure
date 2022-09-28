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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
