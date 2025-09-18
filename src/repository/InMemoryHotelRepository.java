package repository;

import domain.Hotel;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHotelRepository {
    private List<Hotel> hotels = new ArrayList<>();

    public InMemoryHotelRepository() {
        hotels.add(new Hotel(1, "Hotel Atlas", "Casablanca Ain diabe", 4));
        hotels.add(new Hotel(2, "Hotel Sahara", "Marrakech", 5));
        hotels.add(new Hotel(3, "Hotel Rif", "Tanger", 4));
    }

    public List<Hotel> findAll() {
        return hotels;
    }
}