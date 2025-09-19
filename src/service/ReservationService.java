package service;

import domain.Reservation;
import domain.Hotel;
import repository.ReservationRepository;
import repository.HotelRepository;

import java.util.List;
import java.util.UUID;

// Handles reservation, cancellation, and history
public class ReservationService {
    private ReservationRepository reservationRepo;
    private HotelRepository hotelRepo;

    public ReservationService(ReservationRepository reservationRepo, HotelRepository hotelRepo) {
        this.reservationRepo = reservationRepo;
        this.hotelRepo = hotelRepo;
    }

    // Reserve a room (returns message)
    public String reserveRoom(String hotelId, UUID clientId, int nights) {
        Hotel hotel = hotelRepo.findById(hotelId);
        if (hotel == null) return "Hôtel introuvable.";
        if (hotel.getAvailableRooms() <= 0) return "Aucune chambre disponible.";
        if (nights <= 0) return "Nombre de nuits invalide.";

        // Decrement available rooms
        hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
        hotelRepo.save(hotel);

        // Create reservation
        Reservation reservation = new Reservation(hotelId, clientId, nights);
        reservationRepo.save(reservation);

        return "Reservation effectuee.";
    }

    // Cancel a reservation (returns message)
    public String cancelReservation(UUID reservationId, UUID clientId) {
        Reservation reservation = reservationRepo.findById(reservationId);
        if (reservation == null) return "Reservation introuvable.";
        if (!reservation.getClientId().equals(clientId)) return "Vous ne pouvez annuler que vos propres reservations.";

        // Increment available rooms
        Hotel hotel = hotelRepo.findById(reservation.getHotelId());
        if (hotel != null) {
            hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
            hotelRepo.save(hotel);
        }

        reservationRepo.delete(reservationId);
        return "Reservation annulee.";
    }

    // Get reservation history for a client (sorted by date)
    public List<Reservation> getHistory(UUID clientId) {
        List<Reservation> history = reservationRepo.findByClientId(clientId);
        history.sort((a, b) -> b.getTimestamp().compareTo(a.getTimestamp())); // Most recent first
        return history;
    }
}