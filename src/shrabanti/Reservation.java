
package shrabanti;


public class Reservation {
    String passengerName;
    String departureCity;
    String destinationCity;
    String date;
    int numberOfPassengers;

    public Reservation(String passengerName, String departureCity, String destinationCity, String date, int numberOfPassengers) {
        this.passengerName = passengerName;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.date = date;
        this.numberOfPassengers = numberOfPassengers;
    }
}
