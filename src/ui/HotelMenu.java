package ui;

import repository.InMemoryHotelRepository;
import domain.Hotel;

public class HotelMenu {
    private InMemoryHotelRepository hotelRepo;

    public HotelMenu() {
        hotelRepo = new InMemoryHotelRepository();
    }

    public void showMenu() {
        System.out.println(" === Liste des hotels disponibles ===");
        for (Hotel hotel : hotelRepo.findAll()) {
            System.out.println(hotel);
        }
    }
}