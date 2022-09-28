public class Player {
    private Room currentRoom;

    public void move (char direction){
        switch (direction){
            case 'n' -> currentRoom = currentRoom.getN();
            case 'e' -> currentRoom = currentRoom.getE();
            case 'w' -> currentRoom = currentRoom.getW();
            case 's' -> currentRoom = currentRoom.getS();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
