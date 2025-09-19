package service;

import domain.Hotel;
import repository.HotelRepository;
import repository.ReservationRepository;

// Handles hotel creation, update, deletion, and listing
public class HotelService {
    private HotelRepository hotelRepo;
    private ReservationRepository reservationRepo;

    public HotelService(HotelRepository hotelRepo, ReservationRepository reservationRepo) {
        this.hotelRepo = hotelRepo;
        this.reservationRepo = reservationRepo;
    }

    // Create a new hotel (returns message)
    public String createHotel(String hotelId, String name, String address, int rooms, double rating) {
        if (hotelRepo.findById(hotelId) != null) return "Identifiant deja utilise.";
        if (rooms <= 0) return "Nombre de chambres invalide.";
        Hotel hotel = new Hotel(hotelId, name, address, rooms, rating);
        hotelRepo.save(hotel);
        return "Hotel cree.";
    }

    // Update hotel info (returns message)
    public String updateHotel(String hotelId, String name, String address, int rooms) {
        Hotel hotel = hotelRepo.findById(hotelId);
        if (hotel == null) return "Hotel introuvable.";
        if (rooms <= 0) return "Nombre de chambres invalide.";
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setAvailableRooms(rooms);
        hotelRepo.save(hotel);
        return "Hotel mis a jour.";
    }

    // Delete hotel (only if no reservations)
    public String deleteHotel(String hotelId) {
        if (!reservationRepo.findByHotelId(hotelId).isEmpty())
            return "Suppression impossible : reservations en cours.";
        hotelRepo.delete(hotelId);
        return "Hotel supprime.";
    }

    // List all hotels
    public java.util.List<Hotel> listHotels() {
        return hotelRepo.findAll();
    }

    // List hotels with available rooms
    public java.util.List<Hotel> listAvailableHotels() {
        java.util.List<Hotel> result = new java.util.ArrayList<>();
        for (Hotel h : hotelRepo.findAll()) {
            if (h.getAvailableRooms() > 0) result.add(h);
        }
        return result;
    }
}