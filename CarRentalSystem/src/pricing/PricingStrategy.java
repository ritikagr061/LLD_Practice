package pricing;

import entities.Car;

import java.time.LocalDateTime;

public interface PricingStrategy {
    long calcPrice(Car car, LocalDateTime pickupTime, LocalDateTime dropOffTime);
}
