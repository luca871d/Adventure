public class Map {
    public Room mapCreation(){
        Room room1 = new Room("room 1", "desc 1", null, null,null,null);
        Room room2 = new Room("room 2", "desc 2", null, null,room1,null);
        room1.setE(room2);
        Room room3 = new Room("room 3", "desc 3", null, null,room2,null);
        room2.setE(room3);
        Room room4 = new Room("room 4", "desc 4", room1, null,null,null);
        room1.setS(room4);
        Room room5 = new Room("room 5", "desc 5", null, null,null,null);
        Room room6 = new Room("room 6", "desc 6", room3, null,null,null);
        room3.setS(room6);
        Room room7 = new Room("room 7", "desc 7", room4, null,null,null);
        room4.setS(room7);
        Room room8 = new Room("room 8", "desc 8", room5, null,room7 ,null);
        room7.setE(room8);
        room5.setS(room8);
        Room room9 = new Room("room 9", "desc 9", room6, null,room8,null);
        room6.setS(room9);
        room8.setE(room9);
        room2.addItem(new Item("Shiny brass lamp", "lamp"));
        room4.addItem(new Item("Metal rod", "rod"));
        room4.addItem(new Food("Food", "food", 3));
        room4.addItem(new Food("Water", "water", 0));
        room7.addItem(new Food("Green carrot", "carrot", -2));

        return room1;
    }
}
