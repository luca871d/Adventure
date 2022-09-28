public class Adventure {
    private Room currentRoom;

    public Adventure (){

    }

    public void startGame(){
        Map map = new Map();
        currentRoom = map.mapCreation();
        UserInterface ui = new UserInterface();
        char action = 'c';
        while (action != 'x') {
            action = ui.startUp(currentRoom);
            switch (action){
                case 'n' -> currentRoom = currentRoom.getN();
                case 'e' -> currentRoom = currentRoom.getE();
                case 'w' -> currentRoom = currentRoom.getW();
                case 's' -> currentRoom = currentRoom.getS();
            }
        }
    }
}
