package homework08deadline;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Garage {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    static Scanner sc = new Scanner(System.in);
    public static final String MAIN_MENU = "Выберите действие\n" +
            "1. Припарковать новую машину в гараж\n" +
            "2. Убрать машину из гаража\n" +
            "3. Получить количество машин в гараже\n" +
            "0. Выход из программы";

    public static void run() {
        Car ferrari = new SportsCar("Ferrari", "Portofino", 2019, "red", "automatic", 350);
        Car ford = new SportsCar("Ford", "Mustang", 2018, "black", "manual", 300);
        Car opel = new BaseCar("Opel", "Astra", 2002, "gray", "automatic", 180);
        Car volkswagen = new Van("Volkswagen", "Multivan", 2008, "gray", "manual", 160);
        Car man = new Truck("Man", "tga", 2006, "white", "manual", 120);
        Car daf = new Truck("Daf", "xf", 2003, "yellow", "manual", 120);

        Map<Car, Integer> garage = new HashMap<>();
        garage.put(ferrari, 2);
        garage.put(ford, 1);
        garage.put(opel, 6);
        garage.put(volkswagen, 4);
        garage.put(man, 3);
        garage.put(daf, 1);

        printCarInGarage(garage);

        int action = -1;
        while (action != 0) {
            System.out.println(ANSI_YELLOW + MAIN_MENU + ANSI_RESET);
            try {
                action = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                sc.next();
            }
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
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Нет такого пункта");
                    break;
            }
        }
    }

    // метод выводит какие машины сейчас в гараже и их количество
    public static void printCarInGarage(Map<Car, Integer> garage) {
        System.out.println("------Список машин в гараже-------");
        for (Car car : garage.keySet()) {
            System.out.println(car + " | " + garage.get(car) + " шт.");
        }
        System.out.println("----------------------------------");
    }

    // метод для выбора категории автомобиля
    private static int getCategory() {
        System.out.println("Выберите категорию");
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

    /* Метод добавления машины в гараж по выбранной категории (getCar)
    Используется метод addCar для заполнения нужных полей новой машины
    checkCar - проверяет есть ли такая же машина в гараже.
        Есть - количество таких машин увеличится на 1
        Нет -  создается новая машина выбранной категории
    */
    public static void parking(Map<Car, Integer> garage) {
        switch (getCategory()) {
            case 1:
                BaseCar passengerCar = (BaseCar) addCar("BaseCar");
                checkCar(garage, passengerCar);
                printCarInGarage(garage);
                break;
            case 2:
                SportsCar sportsCar = (SportsCar) addCar("SportsCar");
                checkCar(garage, sportsCar);
                printCarInGarage(garage);
                break;
            case 3:
                Truck truck = (Truck) addCar("Truck");
                checkCar(garage, truck);
                printCarInGarage(garage);
                break;
            case 4:
                Van van = (Van) addCar("Van");
                checkCar(garage, van);
                printCarInGarage(garage);
                break;
            default:
                System.out.println("Такой категории в списке нет");
        }
    }

    // Метод создания машины
    private static Car addCar(String category) {
        sc.nextLine();
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

        switch (category) {
            case "BaseCar":
                return new BaseCar(brand, model, year, color, transmission, maxSpeed);
            case "SportsCar":
                return new SportsCar(brand, model, year, color, transmission, maxSpeed);
            case "Truck":
                return new Truck(brand, model, year, color, transmission, maxSpeed);
            case "Van":
                return new Van(brand, model, year, color, transmission, maxSpeed);
            default:
                return null;
        }
    }

    // Метод проверят есть ли такие же машины в гараже
    private static void checkCar(Map<Car, Integer> garage, Car car) {
        // если такая же машина есть в гараже, то их количество увеличится на +1
        // иначе добавится одна новая машина в гараж
        if (garage.containsKey(car)) {
            int count = garage.get(car);
            garage.put(car, count + 1);
        } else {
            garage.put(car, 1);
        }
    }

    // Метод удаляет случайную машину из гаража
    public static void setOut(Map<Car, Integer> garage) {
        Set<Car> set = garage.keySet();
        List<Car> listCar = new ArrayList<>();
        for (Car c : set) {
            listCar.add(c);
        }

        Car randomCarFromGarage = null;
        int randomNumber = (int) (Math.random() * listCar.size()); // [0..listCar.size()]
        if (listCar.size() != 0) {
            randomCarFromGarage = listCar.get(randomNumber);
        } else {
            System.out.println("Гараж пуст");
            sc.close();
            System.exit(0);
        }

        // если таких машин в гараже несколько,то их количество умееньшается на 1
        // если такая машина в гараже была одна, то она удаляется
        int count = (int) garage.get(randomCarFromGarage);
        if (count >= 2) {
            garage.put(randomCarFromGarage, --count);
            System.out.println("Машин [" + randomCarFromGarage.getBrand() + " " + randomCarFromGarage.getModel() + "] в гараже стало меньше. Теперь их " + count);
            printCarInGarage(garage);
        } else {
            garage.remove(randomCarFromGarage);
            System.out.println("Машина [" + randomCarFromGarage.getBrand() + " " + randomCarFromGarage.getModel() + "] выехала из гаража");
            printCarInGarage(garage);
        }
    }

    // выводит общее количество машин в выбранной категории
    public static void getCar(Map<Car, Integer> garage) {
        switch (getCategory()) {
            case 1:
                System.out.println("Количество машин категории Легковые = " + countCarForCategory(garage, "BaseCar"));
                break;
            case 2:
                System.out.println("Количество машин категории Спортивные = " + countCarForCategory(garage, "SportsCar"));
                break;
            case 3:
                System.out.println("Количество машин категории Грузовики = " + countCarForCategory(garage, "Truck"));
                break;
            case 4:
                System.out.println("Количество машин категории Бусы = " + countCarForCategory(garage, "Van"));
                break;
            default:
                System.out.println("Такой категории в списке нет");
        }
    }

    //метод получает имя категории и считает машины
    public static int countCarForCategory(Map<Car, Integer> garage, String carCategory) {
        int count = 0;
        for (Car car : garage.keySet()) {
            String str = car.getClass().getName();
            Pattern pattern = Pattern.compile(carCategory);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                count = count + garage.get(car);
            }
        }
        return count;
    }
}