package com.gyoge.apcs;

@SuppressWarnings("unused")
public interface IntegerList {
    void add(int index, Integer element);

    boolean add(Integer element);

    Integer get(int index);

    Integer remove(int index);

    Integer set(int index, Integer element);

    int size();

    int indexOf(Integer element);
}
