package repository;

import domain.Hotel;
import java.util.ArrayList;
import java.util.List;

// In-memory implementation of HotelRepository
public class InMemoryHotelRepository implements HotelRepository {
    private List<Hotel> hotels = new ArrayList<>();

    @Override
    public void save(Hotel hotel) {
        Hotel existing = findById(hotel.getHotelId());
        if (existing != null) {
            hotels.remove(existing);
        }
        hotels.add(hotel);
    }

    @Override
    public Hotel findById(String hotelId) {
        for (Hotel h : hotels) {
            if (h.getHotelId().equals(hotelId)) return h;
        }
        return null;
    }

    @Override
    public List<Hotel> findAll() {
        return new ArrayList<>(hotels);
    }

    @Override
    public void delete(String hotelId) {
        Hotel h = findById(hotelId);
        if (h != null) hotels.remove(h);
    }
}