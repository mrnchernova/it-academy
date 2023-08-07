package streams;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Processor> processors = new ArrayList<>();
        processors.add(new Processor("Intel Core i3", 3.6));
        processors.add(new Processor("Intel Core i5", 2.6));
        processors.add(new Processor("Intel Core i7", 3.6));
        processors.add(new Processor("Intel Core i9", 4.5));
        processors.add(new Processor("AMD Ryzen 3", 3.6));
        processors.add(new Processor("AMD Ryzen 5", 3.9));
        processors.add(new Processor("AMD Ryzen 7", 3.8));
        processors.add(new Processor("AMD Ryzen 9", 4.7));
        processors.add(new Processor("Intel Pentium", 3.7));
        processors.add(new Processor("Intel Celeron", 3.5));
        processors.add(new Processor("Intel Celeron", 3.5));

        System.out.println(".forEach");
        processors.stream()
                .forEach(System.out::println);


//        System.out.println("\n.filter (CPU >= 4)");
//        processors.stream()
//                .filter(p -> p.getCpu() >= 4)
//                .forEach(System.out::println);

//        System.out.println("\n.sorted (by Title)");
//        processors.stream()
////              .sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
//                .sorted(Comparator.comparing(Processor::getTitle))
//                .forEach(System.out::println);

//        System.out.println("\n.sorted (by CPU)");
//        processors.stream()
////      processors.sort((p1, p2) -> Double.valueOf(p1.getCpu()).compareTo(p2.getCpu()));
//                .sorted(Comparator.comparing(Processor::getCpu))
//                .forEach(System.out::println);


//        System.out.println("\n.sorted (by All)");
//        processors.stream().sorted(Comparator.comparing(Processor::getTitle)
//                        .thenComparing(Processor::getCpu))
//                .forEach(System.out::println);


//        System.out.println("\n.map (super speed +10)");
//        processors.stream()
//                .map(p -> {
//                    return new Processor(
//                            "Super " + p.getTitle(),
//                            p.getCpu() + 10);
//                })
//                .forEach(System.out::println);


//        System.out.println("\n.collect (from List to unique List)");
//        processors
//                .stream().collect(Collectors.toSet())
//                .stream().collect(Collectors.toList())
//                .forEach(System.out::println);


//        System.out.println("\n.distinct (without dublicate 'Intel Celeron 3.5')");
//        processors.stream()
//                .distinct()
//                .forEach(System.out::println);


//        System.out.println(".peek");
//        processors.stream()
//                .distinct()
//                .limit(4)
//                .peek(System.out::println)
//                .count();

    }
}
