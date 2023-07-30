package homework06.classwork;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[]{new Dog(), new Cat(), new Horse()};

        Doctor doc = new Doctor();

        for (Animal animal : animals) {
            System.out.println(animal);
            doc.treatAnimal(animal);
        }
    }
}
