public class Adventure {
    private UserInterface ui = new UserInterface();
    private Map map = new Map();
    private Player player = new Player();

    public void startGame(){
        player.setCurrentRoom(map.mapCreation());
        ui.lookAround(player.lookAround(), player.lookAtEnemies());
        Action action = new Action(PlayerChoice.CONTINUE, null);
        while (action.getPlayerChoice() != PlayerChoice.EXIT || player.getHealth() <= 0) {
            action = ui.startUp();
            switch (action.getPlayerChoice()){
                case NORTH,EAST,WEST,SOUTH ->{
                    if (player.move(action.getPlayerChoice())){
                        ui.lookAround(player.lookAround(), player.lookAtEnemies());
                    }
                    else {
                        ui.cantMove();
                    }
                }
                case INVENTORY -> ui.inventory(player.getInventory());
                case LOOK -> ui.lookAround(player.lookAround(), player.lookAtEnemies());
                case TAKE -> {
                    boolean isItem = player.takeItem(action.getPlayerChoiceItem());
                    if (!isItem){
                        ui.noItem("the room");
                    }
                }
                case DROP -> {
                    boolean isItem = player.dropItem(action.getPlayerChoiceItem());
                    if (!isItem){
                        ui.noItem("your inventory");
                    }
                }
                case HEALTH -> ui.currentHealth(player.getHealth());
                case EAT -> {
                    Usable canEat = player.eatFood(action.getPlayerChoiceItem());
                    switch (canEat) {
                        case NOITEM -> ui.noFood();
                        case HASITEM -> ui.cantEat();
                        case USABLE -> {
                            ui.ate();
                            ui.currentHealth(player.getHealth());
                        }
                    }
                }
                case EQUIP -> {
                    Usable canEquip = player.equip(action.getPlayerChoiceItem());
                    switch (canEquip) {
                        case NOITEM -> ui.noItem("your inventory");
                        case HASITEM -> ui.cantEquip();
                        case USABLE -> ui.equip();
                    }
                }
                case ATTACK -> {
                    switch (player.attack()){
                        case NOITEM -> ui.cantAttack();
                        case HASITEM -> ui.emptyAttack();
                        case USABLE -> ui.attack();
                        case DEFEATED -> ui.defeated();
                    }
                }
            }
        }
        if (action.getPlayerChoice() == PlayerChoice.EXIT){
            ui.exit();
        }
        else {
            ui.gameOver();
        }
    }
}
