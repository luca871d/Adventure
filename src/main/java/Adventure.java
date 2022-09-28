public class Adventure {
    private Room currentRoom;
    private UserInterface ui = new UserInterface(this);
    private Map map = new Map();
    private Player player = new Player();

    public void startGame(){
        player.setCurrentRoom(map.mapCreation());
        char action = 'c';
        while (action != 'x') {
            action = ui.startUp(player.getCurrentRoom());
        }
    }

    public Player getPlayer() {
        return player;
    }
}
