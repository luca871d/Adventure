public class Room {
    private String name;
    private String description;
    private Room n;
    private Room e;
    private Room w;
    private Room s;

    public Room (String name, String description, Room n, Room e, Room w, Room s){
        this.name = name;
        this.description = description;
        this.n = n;
        this.e = e;
        this.w = w;
        this.s = s;
    }

    public String[] lookAround(){
        String[] roomDetails = {name, description};
        return roomDetails;
    }
}
