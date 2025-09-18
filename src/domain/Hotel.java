package domain;

public class Hotel {
    private int id;
    private String name;
    private String address;
    // private boolean availableRooms;
    private int rating;



    public Hotel(int id, String name, String address, int rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
         return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getAdress() { 
        return address; 
    }

    public int getRating() { 
        return rating; 
    }


    @Override
    public String toString() {
        return "Hotel{id=" + id + ", name='" + name + "', address='" + address + "', rating=" + rating + "}";
    }
}