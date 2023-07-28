package homework08deadline;

import java.util.Objects;

public class SportsCar extends Car{


    public SportsCar(String brand, String model, int year, String color, String transmission, int maxSpeed) {
        super(brand, model, year, color, transmission, maxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() &&
                getMaxSpeed() == car.getMaxSpeed() &&
                Objects.equals(getBrand(), car.getBrand()) &&
                Objects.equals(getModel(), car.getModel()) &&
                Objects.equals(getColor(), car.getColor()) &&
                Objects.equals(getTransmission(), car.getTransmission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getYear(), getColor(), getTransmission(), getMaxSpeed());
    }

    @Override
    public String toString() {
        return "SportsCar   [" +
                "brand='" + getBrand() + '\'' +
                " model='" + getModel() + '\'' +
                " year=" + getYear() +
                " color='" + getColor() + '\'' +
                " transmission='" + getTransmission() + '\'' +
                " maxSpeed=" + getMaxSpeed() +
                ']';
    }
}
