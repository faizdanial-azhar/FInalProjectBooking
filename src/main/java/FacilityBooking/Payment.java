package FacilityBooking;
import java.time.LocalDateTime;

public class Payment {
    private Facility facility;
    private LocalDateTime bookingDateTime;
    private int hoursBooked;
    private float totalPrice;

    public Payment(Facility facility, LocalDateTime bookingDateTime, int hoursBooked) {
        this.facility = facility;
        this.bookingDateTime = bookingDateTime;
        this.hoursBooked = hoursBooked;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        this.totalPrice = facility.getPricePerHour() * hoursBooked;
    }

    public Facility getFacility() {
        return facility;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public int getHoursBooked() {
        return hoursBooked;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
