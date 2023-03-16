// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public interface List<T> {

    void add(int index, T element) throws IndexOutOfBoundsException;

    boolean add(T element) throws IndexOutOfBoundsException;

    T get(int index) throws IndexOutOfBoundsException;

    @SuppressWarnings("UnusedReturnValue")
    T remove(int index) throws IndexOutOfBoundsException;

    T set(int index, T element) throws IndexOutOfBoundsException;

    int size();

    int indexOf(T element);
}
