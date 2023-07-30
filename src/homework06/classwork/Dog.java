package homework06.classwork;

public class Dog extends Animal {

    private String food = "мясо";
    private String location = "город";

    @Override
    public void makeNoise() {
        System.out.println("собака лает");
    }

    @Override
    public void eat() {
        System.out.println("собака ест");
    }

    @Override
    public String getFood() {
        return food;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Это собака";
    }
}
