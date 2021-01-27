import java.util.ArrayList;

public class Bedroom {
    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guests;
    private String type;
    private boolean occupied;
    private double nightlyRate;

    public Bedroom(int roomNumber, int capacity, String type, double nightlyRate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.type = type;
        this.occupied = false;
        this.nightlyRate = nightlyRate;
    }

    public double getNightlyRate() {
        return this.nightlyRate;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest){
        this.guests.remove(guest);
    }

    public ArrayList getRoomGuestList(){
        return this.guests;
    }

    public boolean getOccupancyStatus(){
        return this.occupied;
    }

    public void setOccupancyStatus(boolean status){
        this.occupied = status;
    }

    public String getRoomType(){
        return this.type;
    }

}
