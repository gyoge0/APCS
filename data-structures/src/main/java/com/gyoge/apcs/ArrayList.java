// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T> {
    private T[] data;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public ArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        data = (T[]) (new Object[size]);
    }

    private void grow() {
        T[] temp = (T[]) (new Object[data.length * 2]);
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private void shrink() {
        T[] temp = (T[]) (new Object[data.length / 2]);
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean add(T element) {
        if (size >= data.length) {
            grow();
        }
        data[size++] = element;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        if (size < data.length / 2) {
            shrink();
        }
        size--;
        return ret;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T ret = data[index];
        data[index] = element;
        return ret;
    }

    public int size() {
        return size;
    }

    @Override
    public int indexOf(T element) {
        for (int idx = 0, dataLength = data.length; idx < dataLength; idx++) {
            if (Objects.equals(data[idx], element)) return idx;
        }
        return -1;
    }

    @SuppressWarnings("unused")
    public int indexOf(Integer element) {
        for (int idx = 0, dataLength = data.length; idx < dataLength; idx++) {
            if (Objects.equals(data[idx], element)) return idx;
        }
        return -1;
    }
}
