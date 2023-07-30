package homework07.collection;

import java.util.Collection;

public interface MyList<T> {
    boolean add(T t);

    void add(int index, T t);

    T get(int index);

    boolean addAll(int index, Collection<? extends T> collection);

    int size();

    boolean isEmpty();

    void set(int index, T t);

    boolean contains(Object value);

    boolean remove(Object value);

    T remove(int index);

    int indexOf(Object value);

}
