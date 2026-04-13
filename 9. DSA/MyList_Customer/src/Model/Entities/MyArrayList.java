package Model.Entities;

import java.util.Arrays;

// Sử dụng <E> để đại diện cho kiểu dữ liệu bất kỳ
public class MyArrayList<E> {
    private Object[] elements; // Dùng Object[] để có thể chứa mọi loại đối tượng
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    // Thêm phần tử vào cuối
    public void add(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Lấy phần tử theo vị trí (Cần ép kiểu về E)
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    // Xóa phần tử theo vị trí
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) elements[i] = null;
        size = 0;
    }
}