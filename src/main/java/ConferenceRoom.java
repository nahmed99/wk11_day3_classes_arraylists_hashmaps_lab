import java.util.ArrayList;

public class ConferenceRoom {
    private String name;
    private int capacity;
    private ArrayList<Guest> guests;
    private boolean occupied;

    public ConferenceRoom(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.occupied = false;
    }

}
