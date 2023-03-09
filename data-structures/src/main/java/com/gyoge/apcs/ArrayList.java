package com.gyoge.apcs;

public class ArrayList implements List {
    private int[] data;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public ArrayList() {
        data = new int[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        data = new int[size];
    }

    private void grow() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private void shrink() {
        int[] temp = new int[data.length / 2];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    @Override
    public void add(int index, Integer element) {
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
    public boolean add(Integer element) {
        if (size >= data.length) {
            grow();
        }
        data[size++] = element;
        return true;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public Integer remove(int index) {
        int ret = data[index];
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
    public Integer set(int index, Integer element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int ret = data[index];
        data[index] = element;
        return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Integer element) {
        for (int idx = 0, dataLength = data.length; idx < dataLength; idx++) {
            if (data[idx] == element) return idx;
        }
        return -1;
    }
}
