package com.telran.collection;

import com.telran.comparator.OurComparator;

public class OurArrayList implements List {

    private Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void append(Object o) {
        if (size == source.length) {
            Object[] newSource = new Object[size * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = o;
        size++;
    }

    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return source[index];
    }

    public void set(Object o, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = o;
    }

    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Object o = source[index];
        System.arraycopy(source, index + 1, source, index, size - index);
        size--;

        return o;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(source[i])) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(source[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object max(OurComparator comparator) {
        Object max = source[0];

        for (int i = 1; i < size; i++) {
            if (comparator.compare(max, source[i]) < 0)
                max = source[i];
        }
        return max;
    }

    @Override
    public Object min(OurComparator comparator) {
        return null;
    }

    @Override
    public void sort(OurComparator comparator) {

    }
}
