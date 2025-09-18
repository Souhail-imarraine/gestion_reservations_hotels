package repository;

import domain.Reservation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// In-memory implementation of ReservationRepository
public class InMemoryReservationRepository implements ReservationRepository {
    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public Reservation findById(UUID id) {
        for (Reservation r : reservations) {
            if (r.getId().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Reservation> findByClientId(UUID clientId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getClientId().equals(clientId)) result.add(r);
        }
        return result;
    }

    @Override
    public List<Reservation> findByHotelId(String hotelId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getHotelId().equals(hotelId)) result.add(r);
        }
        return result;
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }

    @Override
    public void delete(UUID id) {
        Reservation r = findById(id);
        if (r != null) reservations.remove(r);
    }
}