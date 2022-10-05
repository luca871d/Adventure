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
                case 'i' -> ui.inventory(player.getInventory());
                case 'l' -> ui.lookAround(player.getCurrentRoom());
                case 't' -> {
                    boolean isItem = player.takeItem(action.substring(2));
                    if (!isItem){
                        ui.noItem("the room");
                    }
                }
                case 'd' -> {
                    boolean isItem = player.dropItem(action.substring(2));
                    if (!isItem){
                        ui.noItem("your inventory");
                    }
                }
                case 'h' -> ui.currentHealth(player.getHealth());
                case 'p' -> {
                    Edible canEat = player.eatFood(action.substring(2));
                    switch (canEat) {
                        case NOFOOD -> ui.noFood();
                        case ISITEM -> ui.cantEat();
                        case EDIBLE -> {
                            ui.ate();
                            ui.currentHealth(player.getHealth());
                        }
                    }
                }
            }
        }
    }
}
