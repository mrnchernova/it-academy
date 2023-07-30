package homework06.classwork;

public class Horse extends Animal {

    private String food = "трава";
    private String location = "улица";

    @Override
    public void makeNoise() {
        System.out.println("лошадь ржет");
    }

    @Override
    public void eat() {
        System.out.println("лошадь ест");
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
        return "Это лошадь";
    }
}
