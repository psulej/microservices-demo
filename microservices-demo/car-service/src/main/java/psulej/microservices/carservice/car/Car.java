package psulej.microservices.carservice.car;

public record Car(
        long carId,
        long userId,
        String brand,
        String model,
        int horsePower
) {
    public Car(long carId, long userId, String brand, String model, int horsePower) {
        this.carId = carId;
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
}
