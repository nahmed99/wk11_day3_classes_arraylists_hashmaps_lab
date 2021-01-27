import java.util.ArrayList;

public class DiningRoom {

    private String name;
    private ArrayList<Guest> guestList;

    public DiningRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Guest> getGuestList() {
        return this.guestList;
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

}
