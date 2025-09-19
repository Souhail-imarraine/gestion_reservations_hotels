package domain;

// Represents a hotel in the system
public class Hotel {
    private String hotelId;        // Unique hotel identifier
    private String name;           // Hotel name
    private String address;        // Hotel address
    private int availableRooms;    // Number of rooms available
    private double rating;         // Hotel rating

    // Constructor
    public Hotel(String hotelId, String name, String address, int availableRooms, double rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.availableRooms = availableRooms;
        this.rating = rating;
    }

    // Getters
    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public double getRating() {
        return rating;
    }

    // Setters for hotel update
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvailableRooms(int rooms) {
        this.availableRooms = rooms;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{id='" + hotelId + "', name='" + name + "', address='" + address +
                "', availableRooms=" + availableRooms + ", rating=" + rating + "}";
    }
}