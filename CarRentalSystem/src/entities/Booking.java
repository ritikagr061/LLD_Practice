package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String bookingId;
    private Car car;
    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;
    private User user;
    private Location pickupLocation;
    private Location dropOffLocation;
    private long amount;
    private BookingStatus status;

    public boolean overlaps(LocalDateTime startTime, LocalDateTime endTime) {
        return pickupTime.isBefore(endTime) && dropOffTime.isAfter(startTime);
    }

    public boolean blocksAvailability() {
        return status == BookingStatus.PENDING_PAYMENT
                || status == BookingStatus.CONFIRMED
                || status == BookingStatus.IN_PROGRESS;
    }

    public void confirm() {
        if (status != BookingStatus.PENDING_PAYMENT) {
            throw new IllegalStateException("Only pending bookings can be confirmed");
        }
        status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == BookingStatus.COMPLETED) {
            throw new IllegalStateException("Completed booking cannot be cancelled");
        }
        status = BookingStatus.CANCELLED;
    }

    public void startTrip() {
        if (status != BookingStatus.CONFIRMED) {
            throw new IllegalStateException("Only confirmed bookings can be started");
        }
        status = BookingStatus.IN_PROGRESS;
    }

    public void completeTrip() {
        if (status != BookingStatus.IN_PROGRESS) {
            throw new IllegalStateException("Only in-progress bookings can be completed");
        }
        status = BookingStatus.COMPLETED;
        car.setLocation(dropOffLocation);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + bookingId + '\'' +
                ", car=" + car.getNumberPlate() +
                ", pickupTime=" + pickupTime +
                ", dropOffTime=" + dropOffTime +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
