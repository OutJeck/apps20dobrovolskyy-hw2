package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] array;

    public ImmutableArrayList() {
        this.array = new Object[0];
    }

    public ImmutableArrayList(Object[] c) {
        this.array = c.clone();
    }

    @Override
    public ImmutableList add(Object e) {
        return add(array.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[array.length + c.length];
        System.arraycopy(array, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(array, index,
                         newArr, index + c.length,
                         array.length - index);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[array.length - 1];
        System.arraycopy(array, 0, newArr, 0, index);
        System.arraycopy(array, index + 1, newArr,
                index, array.length - 1 - index);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[array.length];

        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[index] = e;
        return new ImmutableArrayList(newArr);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
