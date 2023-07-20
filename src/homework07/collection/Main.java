package homework07.collection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> arrayWithCapacity = new MyArrayList<>(4);
        System.out.println(arrayWithCapacity);

        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("zero");
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        System.out.println(arrayList.isEmpty());

        System.out.println(arrayList.get(1));

        arrayList.add("last_element");
        System.out.println(arrayList);

        arrayList.add(4, "x");
        System.out.println(arrayList);

        arrayList.addAll(5, Arrays.asList("q1", "q2"));
        System.out.println(arrayList);

        System.out.println(arrayList.contains("first"));

        arrayList.remove("first");
        System.out.println(arrayList);

        System.out.println(arrayList.remove(0));
        System.out.println(arrayList);

        System.out.println(arrayList.indexOf("sec"));

        arrayList.set(5, "hello_world!");
        System.out.println(arrayList);
    }
}