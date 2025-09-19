package domain;

import java.time.Instant;
import java.util.UUID;

// Represents a reservation made by a client for a hotel
public class Reservation {
    private UUID id;
    private Instant timestamp;
    private String hotelId;
    private UUID clientId;
    private int nights;          // Number of nights reserved

    // Constructor
    public Reservation(String hotelId, UUID clientId, int nights) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.hotelId = hotelId;
        this.clientId = clientId;
        this.nights = nights;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getHotelId() {
        return hotelId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", timestamp=" + timestamp +
                ", hotelId='" + hotelId + "', clientId=" + clientId +
                ", nights=" + nights + "}";
    }
}