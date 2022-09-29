public class Adventure {
    private UserInterface ui = new UserInterface();
    private Map map = new Map();
    private Player player = new Player();

    public void startGame(){
        player.setCurrentRoom(map.mapCreation());
        ui.lookAround(player.getCurrentRoom());
        String action = "c";
        while (!action.equals("x")) {
            action = ui.startUp();
            switch (action.charAt(0)){
                case 'n','e','w','s' ->{
                    if (player.move(action.charAt(0))){
                        ui.lookAround(player.getCurrentRoom());
                    }
                    else {
                        ui.cantMove();
                    }
                }
                case 'l' -> ui.lookAround(player.getCurrentRoom());
                case 't' -> {
                    if (!player.takeItem(action.substring(2))){
                        ui.noItem();
                    }
                }
            }
        }
    }
}
