package entities;

import enums.carType;

public class Car {
    boolean isAvailable;
    carType carType;
    String modelName;
    Long pricePerHour;

    public Car(boolean isAvailable, enums.carType carType, String modelName, Long pricePerHour) {
        this.isAvailable = isAvailable;
        this.carType = carType;
        this.modelName = modelName;
        this.pricePerHour = pricePerHour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public enums.carType getCarType() {
        return carType;
    }

    public void setCarType(enums.carType carType) {
        this.carType = carType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
