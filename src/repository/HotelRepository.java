package repository;

import domain.Hotel;
import java.util.List;

// Interface for hotel data access
public interface HotelRepository {
    void save(Hotel hotel); // Add or update hotel
    Hotel findById(String hotelId); // Find hotel by ID
    List<Hotel> findAll(); // List all hotels
    void delete(String hotelId); // Remove hotel
}