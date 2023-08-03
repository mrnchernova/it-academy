package lesson13.tryStream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Processor> processors = new ArrayList<>();
        processors.add(new Processor("Intel Core i3", 3.6));
        processors.add(new Processor("Intel Core i5", 2.6));
        processors.add(new Processor("Intel Core i7", 3.6));
        processors.add(new Processor("Intel Core i9", 4.5));
        processors.add(new Processor("Intel Ryzen 3", 3.6));
        processors.add(new Processor("Intel Ryzen 5", 3.9));
        processors.add(new Processor("Intel Ryzen 7", 3.8));
        processors.add(new Processor("Intel Ryzen 9", 4.7));
        processors.add(new Processor("Intel Pentium", 3.7));
        processors.add(new Processor("Intel Celeron", 3.5));
        processors.add(new Processor("Intel Celeron", 3.5));

        System.out.println(".forEach");
        processors.stream()
                .forEach(System.out::println);// для каждого элемента коллекции процесс нужно вызвать метод принтлн


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


        System.out.println(".flatMap");

//        System.out.println(".mapToInt");
//        System.out.println(".mapToLong");
//        System.out.println(".mapToDouble");
//        System.out.println(".flatMapToInt");
//        System.out.println(".flatMapToLong");
//        System.out.println(".flatMapToDouble");
//        System.out.println(".distinct");
//        System.out.println(".peek");
//        System.out.println(".limit");
//        System.out.println(".skip");
//        System.out.println(".takeWhile");
//        System.out.println(".dropWhile");
//        System.out.println(".forEachOrdered");
//        System.out.println(".toArray");
//        System.out.println(".reduce");
//        System.out.println(".min");
//        System.out.println(".max");
//        System.out.println(".count");
//        System.out.println(".anyMatch");
//        System.out.println(".allMatch");
//        System.out.println(".noneMatch");
//        System.out.println(".findFirst");
//        System.out.println(".findAny");
//        System.out.println(".builder");
//        System.out.println(".empty");
//        System.out.println(".of");
//        System.out.println(".ofNullable");
//        System.out.println(".iterate");

//        https://javarush.com/groups/posts/3796-kofe-breyk-108-12-rasprostranennihkh-sposobov-ispoljhzovanija-java-streams-kak-ocenitjh-vihdele

/*
        List<Processor> proc = processors.stream()
                .filter((p) -> p.getCpu() >= 4)
                .collect(Collectors.toList());
        proc.forEach(e -> System.out.println(e));
*/

    }
}