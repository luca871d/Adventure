public class Adventure {
    private UserInterface ui = new UserInterface();
    private Map map = new Map();
    private Player player = new Player();

    public void startGame(){
        player.setCurrentRoom(map.mapCreation());
        char action = 'c';
        while (action != 'x') {
            action = ui.startUp();
            switch (action){
                case 'n','e','w','s' ->{
                    if (player.move(action)){
                        ui.lookAround(player.getCurrentRoom());
                    }
                    else {
                        ui.cantMove();
                    }
                }
                case 'l' -> ui.lookAround(player.getCurrentRoom());
            }
        }
    }
}
