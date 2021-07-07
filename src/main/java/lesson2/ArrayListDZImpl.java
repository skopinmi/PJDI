package lesson2;

import java.util.Arrays;

public class ArrayListDZImpl <E> implements ArrayListDZ<E> {

    protected static final int DEFAULT_SIZE = 15;
    private int size;
    private E[] data;


    public ArrayListDZImpl(){
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayListDZImpl(int arraySize) {
        this.data = (E[]) new Object[arraySize];
    }


    @Override
    public void add(E value) {
        checkAndResize();
        data[size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public boolean remove(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (size > index) {
            E result = data[index];
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
            return result;
        }
        return null;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkAndResize() {
        if (data.length == size) {
            data = Arrays.copyOf(data, size * 2);
        }
    }
}
