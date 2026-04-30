package pricing;

import entities.Car;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HighDemandPricing implements PricingStrategy{
    @Override
    public long calcPrice(Car car, LocalDateTime pickupTime, LocalDateTime dropOffTime) {
        int rentPerDay = car.getRentPerDay();
        long hours = ChronoUnit.HOURS.between(pickupTime, dropOffTime);
        long days = Math.max(1, (long) Math.ceil(hours / 24.0));

        return rentPerDay*days*2;
    }
}
