package homework06.classwork;

public class Cat extends Animal {

    private String food = "молоко";
    private String location = "дом";

    @Override
    public void makeNoise() {
        System.out.println("кошка мурчит");
    }

    @Override
    public void eat() {
        System.out.println("кошка ест");
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
        return "Это кот";
    }
}
