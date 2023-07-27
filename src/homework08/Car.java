package homework08;

public abstract class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String transmission;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String model, int year, String color, String transmission, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.transmission = transmission;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public abstract String toString();
}
