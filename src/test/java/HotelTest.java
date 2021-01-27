import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HotelTest {
    Hotel hotelCalifornia;
    Bedroom bedroom;

    @Before
    public void before(){
        hotelCalifornia = new Hotel("Hotel California");
        hotelCalifornia.buildHotel();

        bedroom = new Bedroom(5, 1, "single", 100.00);
        hotelCalifornia.addRoom(bedroom);
    }

    @Test
    public void canCreateHotel(){
        Hotel myHotel = new Hotel("Bates Motel");
        assertNotNull(myHotel);
    }

    @Test
    public void canCheckInGuest(){
        Guest nawaz = new Guest("Nawaz");
        hotelCalifornia.checkInGuest(nawaz, "single", 3);
        assertEquals(1, hotelCalifornia.getOccupiedBedrooms());

    }

    @Test
    public void canCheckOutGuest(){
        Guest nawaz = new Guest("Nawaz");
        hotelCalifornia.checkInGuest(nawaz, "single", 3);
        hotelCalifornia.checkOutGuest(nawaz);
        assertEquals(0, hotelCalifornia.getOccupiedBedrooms());

    }

    @Test
    public void canMakeBooking(){
        Booking booking = hotelCalifornia.bookRoom(bedroom, 3);
        assertEquals(300, hotelCalifornia.getTotalBill(booking), 0.00);
    }


    @Test
    public void canAddDiningRoom(){
        assertEquals(1, hotelCalifornia.diningRoomCount());
    }


    @Test
    public void canGetUnoccupiedRooms(){
        Guest nawaz = new Guest("Nawaz");
        hotelCalifornia.checkInGuest(nawaz, "single", 3);
        hotelCalifornia.getUnoccupiedBedrooms();
        assertEquals(4, hotelCalifornia.countUnoccupiedBedrooms());

    }


}
