package homework06.classwork;

public abstract class Animal {
    private String food;
    private String location;

    public void makeNoise() {
        System.out.println("shhhhh");
    }

    public void eat() {
        System.out.println("num-num");
    }

    public void sleep() {
        System.out.println("z-z-z-z-z-z-z-z");
    }

    public Animal() {
    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
