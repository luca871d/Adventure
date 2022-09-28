public class Player {
    private Room currentRoom;

    public void move (String direction){
        switch (direction){
            case "north" -> {
                if (currentRoom.nHasRoom()) {
                    System.out.println("going north");
                    currentRoom = currentRoom.getN();
                    lookAround();
                }
                else {
                    System.out.println("You cannot go that way");
                }
            }
            case "east" -> {
                if (currentRoom.eHasRoom()) {
                    System.out.println("going east");
                    currentRoom = currentRoom.getE();
                    lookAround();
                }
                else {
                    System.out.println("You cannot go that way");
                }
            }
            case "west" -> {
                if (currentRoom.wHasRoom()) {
                    System.out.println("going west");
                    currentRoom = currentRoom.getW();
                    lookAround();
                }
                else {
                    System.out.println("You cannot go that way");
                }
            }
            case "south" -> {
                if (currentRoom.sHasRoom()) {
                    System.out.println("going south");
                    currentRoom = currentRoom.getS();
                    lookAround();
                }
                else {
                    System.out.println("You cannot go that way");
                }
            }
            default -> System.out.println("unknown direction");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    private void lookAround(){
        String[] roomDetails = currentRoom.lookAround();
        System.out.println("You are in " + roomDetails[0]);
        System.out.println(roomDetails[1]);
    }
}
