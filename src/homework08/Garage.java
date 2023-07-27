package homework08;

import java.time.LocalDate;
import java.util.*;

public class Garage {
    static Scanner sc = new Scanner(System.in);

    public static void run() {
        Car ferrari = new SportsCar("Ferrari", "Portofino", 2019, "red", "automatic", 350);
        Car ford = new SportsCar("Ford", "Mustang", 2018, "black", "manual", 300);
        Car opel = new BaseCar("Opel", "Astra", 2002, "gray", "automatic", 180);
        Car volkswagen = new Van("Volkswagen", "Multivan", 2008, "gray", "manual", 160);
        Car man = new Truck("Man", "tga", 2006, "white", "manual", 120);
        Car daf = new Truck("Daf", "xf", 2003, "yellow", "manual", 120);
        Car test = new Truck("1", "1", 2000, "1", "1", 1);

        Map<Car, Integer> garage = new HashMap<>();
        garage.put(ferrari, 2);
        garage.put(ford, 1);
        garage.put(opel, 6);
        garage.put(volkswagen, 4);
        garage.put(man, 3);
        garage.put(daf, 1);
        garage.put(test, 1);

        System.out.println("------Список машин в гараже-------");
        for (Car car : garage.keySet()) {
            System.out.println(car);
        }
        System.out.println("-------------");

        System.out.println("Выберите действие\n" +
                "1. Припарковать новую машину в гараж\n" +
                "2. Убрать машину из гаража\n" +
                "3. Получить количество машин в гараже (не работает)");
        while (!sc.hasNextInt()) {
            System.out.println("Введите число");
            sc.next();
        }
        int action = sc.nextInt();
        switch (action) {
            case 1:
                parking(garage);
                break;
            case 2:
                setOut(garage);
                break;
            case 3:
                getCar(garage);
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    // Метод добавления машины в гараж
    public static void parking(Map garage) {
        switch (getCategory()) {
            case 1:
                BaseCar passengerCar = (BaseCar) addCar();
                checkCar(garage, passengerCar);
                break;
            case 2:
                SportsCar sportsCar = (SportsCar) addCar();
                checkCar(garage, sportsCar);
                break;
            case 3:
                Truck truck = (Truck) addCar();
                checkCar(garage, truck);
                break;
            case 4:
                Van van = (Van) addCar();
                checkCar(garage, van);
                break;
            default:
                System.out.println("Такой категории в списке нет");
        }
    }

    // Метод проверят есть ли такие же машины в гараже
    private static void checkCar(Map garage, Car car) {
        // если такая же машина есть в гараже, то их количество увеличится на +1
        // иначе добавится одна новая машина в гараж
        if (garage.containsKey(car)) {
            int count = (int) garage.get(car);
            garage.put(car, count + 1);
        } else {
            garage.put(car, 1);
        }
    }

    // Метод создания обычной машины
    private static Car addCar() {
        System.out.println("Введите марку машины");
        String brand = sc.nextLine();

        System.out.println("Введите модель");
        String model = sc.nextLine();

        System.out.println("Год выпуска");
        boolean yearChecked = false;
        int year = 0;
        while (!yearChecked) {
            while (!sc.hasNextInt()) {
                System.out.println("Это не год");
                sc.next();
            }
            year = sc.nextInt();
            if ((year > LocalDate.now().getYear()) || (year <= 1885)) {
                System.out.println("Неправильный год. Попробуйте еще раз");
            } else {
                yearChecked = true;
            }
        }
        sc.nextLine();
        System.out.println("Цвет машины");
        String color = sc.nextLine();

        System.out.println("Коробка передач");
        String transmission = sc.nextLine();

        System.out.println("Максимальная скорость");

        while (!sc.hasNextInt()) {
            System.out.println("Это не число");
            sc.next();
        }
        int maxSpeed = sc.nextInt();

        System.out.println("Марка: " + brand);
        System.out.println("Мадель: " + model);
        System.out.println("Год: " + year);
        System.out.println("Цвет: " + color);
        System.out.println("Коробка передач: " + transmission);
        System.out.println("Максимальная скорость: " + maxSpeed);

        return new BaseCar(brand, model, year, color, transmission, maxSpeed);
    }

    // Метод удаляет случайную машину из гаража
    public static void setOut(Map garage) {
        Set<Car> set = garage.keySet();
        Car randomCarFromGarage = set.iterator().next();
        // если таких машин в гараже несколько,то их количество умееньшается на 1
        // если такая машина в гараже была одна, то она удаляется
        checkCar(garage, randomCarFromGarage);
        int count = (int) garage.get(randomCarFromGarage);
        if (count > 2) {
            garage.put(randomCarFromGarage, count - 1);
            System.out.println("Машин [" + randomCarFromGarage.getBrand() + " " + randomCarFromGarage.getModel() + "] в гараже стало меньше");
        } else {
            garage.remove(randomCarFromGarage);
            System.out.println("Машина [" + randomCarFromGarage.getBrand() + " " + randomCarFromGarage.getModel() + "] выехала из гаража");
        }
    }

    // метод для выбора категории автомобиля
    private static int getCategory() {
        System.out.println("Choose number of car category");
        System.out.println("1 Легковая машина");
        System.out.println("2 Спортивная машина");
        System.out.println("3 Грузовик");
        System.out.println("4 Бус");

        while (!sc.hasNextInt()) {
            System.out.println("Введите число");
            sc.next();
        }
        return sc.nextInt();
    }

    // метод для получения количества определенного вида автомобилей
    public static void getCar(Map garage) {
        switch (getCategory()) {
            case 1:
                //TODO вывести все авто этого вида
                // посчитать v каждоо авто
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Такой категории в списке нет");
        }

    }


}
