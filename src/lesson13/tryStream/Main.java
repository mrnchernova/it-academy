package lesson13.tryStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

/* Номальная запись
        for (Processor p : processors)
            System.out.println(p);
*/
        
//        processors.stream().forEach((Processor p) -> System.out.println(p));
        processors.stream().forEach(System.out::println);// для каждого элемента коллекции процесс нужно вызвать метод принтлн

        https://www.youtube.com/watch?v=DNC6Lknn2AE
        
/*
        List<Processor> proc = processors.stream()
                .filter((p) -> p.getCpu() >= 4)
                .collect(Collectors.toList());
        proc.forEach(e -> System.out.println("что ты такое? " + e));
*/

    }
}