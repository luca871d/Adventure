public class Adventure {
    private Room currentRoom;

    public Adventure (){

    }

    public void startGame(){
        Room room1 = new Room("room 1", "desc 1", null, null,null,null);
        currentRoom = room1;
        UserInterface ui = new UserInterface();
        ui.startUp(currentRoom);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
