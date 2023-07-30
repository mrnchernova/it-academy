package homework07.collection;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private Object[] array;

    public MyArrayList() {
        array = new Object[0];
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
    }

    private void addEmptyLastElement() {
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

    @Override
    public boolean add(Object t) {
        addEmptyLastElement();
        array[array.length - 1] = t;
        return true;
    }

    @Override
    public void add(int index, Object t) {
        if (index <= array.length && index >= 0) {
            addEmptyLastElement();
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = t;
        } else {
            System.out.println("ERROR: индекс для вставки выходит за пределы массива");
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (collection.isEmpty() || (index < 0)) {
            return false;
        }
        if (index > array.length) {
            index = array.length;
        }
        for (Object item : collection) {
            add(index++, item);
        }
        return true;
    }

    @Override
    public boolean remove(Object value) {
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                for (int el = 0; el < newArray.length; el++) {
                    newArray[el] = array[el];
                }
                array = newArray;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T deleted = (T) array[index];
        Object[] newArray = new Object[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        for (int el = 0; el < newArray.length; el++) {
            newArray[el] = array[el];
        }
        array = newArray;
        return deleted;
    }

    @Override
    public boolean contains(Object value) {
        for (Object element : array) {
            if (element.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void set(int index, T t) {
        array[index] = t;
    }

    @Override
    public String toString() {
        return "array=" + Arrays.toString(array);
    }
}
