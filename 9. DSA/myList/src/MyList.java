import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Khởi tạo mảng với kích thước mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Khởi tạo mảng với kích thước tùy chọn
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    // Tăng kích thước mảng khi đầy
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Thêm phần tử vào vị trí index cụ thể
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        ensureCapacity(size + 1);
        // Dịch chuyển các phần tử sang phải để tạo chỗ trống
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Xóa phần tử tại vị trí index
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Dịch chuyển các phần tử sau index sang trái để lấp chỗ trống
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Xóa tham chiếu để hỗ trợ Garbage Collector
        return removedElement;
    }

    // Lấy phần tử tại index
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i);
        return (E) elements[i];
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) elements[i] = null;
        size = 0;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) return i;
        }
        return -1;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }
}