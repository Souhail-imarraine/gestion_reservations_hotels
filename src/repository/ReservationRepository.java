package repository;

import domain.Reservation;

import java.util.List;
import java.util.UUID;

// Interface for reservation data access
public interface ReservationRepository {
    void save(Reservation reservation); // Add reservation

    Reservation findById(UUID id); // Find by reservation ID

    List<Reservation> findByClientId(UUID clientId); // Find reservations by client

    List<Reservation> findByHotelId(String hotelId); // Find reservations by hotel

    List<Reservation> findAll(); // List all reservations

    void delete(UUID id); // Remove reservation
}