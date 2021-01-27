public class Booking {

    private Bedroom bedroom;
    private int noOfNightsBooked;


    public Booking(Bedroom bedroom, int noOfNightsBooked) {
        this.bedroom = bedroom;
        this.noOfNightsBooked = noOfNightsBooked;
    }

    public double getBedroomPrice() {
        return this.bedroom.getNightlyRate();
    }

    public int getNoOfNightsBooked() {
        return this.noOfNightsBooked;
    }

}
