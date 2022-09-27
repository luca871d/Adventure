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

    public void setN (Room room){
        n = room;
    }
    public void setE (Room room){
        e = room;
    }
    public void setW (Room room){
        w = room;
    }
    public void setS (Room room){
        s = room;
    }

    public Room getN() {
        return n;
    }

    public Room getE() {
        return e;
    }

    public Room getW() {
        return w;
    }

    public Room getS() {
        return s;
    }

    public boolean nHasRoom(){
        return (n != null);
    }
    public boolean eHasRoom(){
        return (e != null);
    }
    public boolean wHasRoom(){
        return (w != null);
    }
    public boolean sHasRoom(){
        return (s != null);
    }
}
