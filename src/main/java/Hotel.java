import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;
    private ArrayList<Bedroom> unoccupiedRooms;

    public Hotel(String name){
        this.name = name;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms = new HashMap<String, DiningRoom>();
    }

    //Method to add bedrooms to bedrooms ArrayList
    public void buildHotel(){
        Bedroom room1 = new Bedroom(1, 2, "double", 50.0);
        Bedroom room2 = new Bedroom(2, 1, "single", 45.0);
        Bedroom room3 = new Bedroom(3, 2, "double", 99.50);
        Bedroom room4 = new Bedroom(4, 1, "single", 75.00);

        this.bedrooms.add(room1);
        this.bedrooms.add(room2);
        this.bedrooms.add(room3);
        this.bedrooms.add(room4);

        ConferenceRoom skye = new ConferenceRoom("Skye", 5);
        ConferenceRoom arran = new ConferenceRoom("Arran", 4);
        ConferenceRoom islay = new ConferenceRoom("Islay", 5);
        ConferenceRoom jura = new ConferenceRoom("Jura", 3);

        this.conferenceRooms.add(skye);
        this.conferenceRooms.add(arran);
        this.conferenceRooms.add(islay);
        this.conferenceRooms.add(jura);

        DiningRoom laura = new DiningRoom("Laura");
        addDiningRoom(laura);
    }

    public void addRoom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        this.diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public int diningRoomCount() {
        return this.diningRooms.size();
    }

    public void checkInGuest(Guest guest, String roomType, int noOfNights){
        for(Bedroom bedroom : this.bedrooms){
            if (!bedroom.getOccupancyStatus() && bedroom.getRoomType() == roomType){
                bedroom.addGuest(guest);
                bookRoom(bedroom, noOfNights);
                bedroom.setOccupancyStatus(true);
                break;
            }
        }

    }

    public int getOccupiedBedrooms(){
        int counter = 0;

        for(Bedroom bedroom : this.bedrooms){
            if (bedroom.getOccupancyStatus()){
                counter ++;
            }
        }
        return counter;
    }


    public ArrayList getUnoccupiedBedrooms(){
        unoccupiedRooms = new ArrayList<>();
        for(Bedroom bedroom : this.bedrooms){
            if (!bedroom.getOccupancyStatus()){
                unoccupiedRooms.add(bedroom);
            }
        }
        return unoccupiedRooms;
    }

    public int countUnoccupiedBedrooms() {
        return unoccupiedRooms.size();
    }




    public void checkOutGuest(Guest guest){
        for(Bedroom bedroom : this.bedrooms){
            if (bedroom.getRoomGuestList().contains(guest)){
//                Bedroom roomToCheckOut = bedroom;
                bedroom.removeGuest(guest);
                bedroom.setOccupancyStatus(false);
            }
        }
    }

    public Booking bookRoom(Bedroom bedroom, int noOFNights) {
        Booking booking = new Booking(bedroom, noOFNights);
        return booking;
    }

    public double getTotalBill(Booking booking) {
        return booking.getBedroomPrice() * booking.getNoOfNightsBooked();
    }
}
