package Classes;

import Classes.Entrenador;

/**
 *
 * @author MemoL
 */
public class PriorityQueue {

    private Entrenador[] heap;
    private int heapSize, capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity + 1;
        heap = new Entrenador[this.capacity];
        heapSize = 0;
    }

    public void clear() {
        heap = new Entrenador[capacity];
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == capacity - 1;
    }

    public int size() {
        return heapSize;
    }

    public void insert(Entrenador entrenador) {
        heap[++heapSize] = entrenador;
        int pos = heapSize;
        while (pos != 1 && entrenador.byteSize() > heap[pos / 2].byteSize()) {
            heap[pos] = heap[pos / 2];
            pos /= 2;
        }
        heap[pos] = entrenador;
    }

    public Entrenador Peek() {
        return heap[1];
    }

    public Entrenador DEQUEUE() {
        int parent, child;
        Entrenador item, temp;
        if (isEmpty()) {
            System.out.println("Vacio");
            return null;
        }

        item = heap[1];
        temp = heap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize) {
            if (child < heapSize && heap[child].byteSize() < heap[child + 1].byteSize()) {
                child++;
            }
            if (temp.byteSize() >= heap[child].byteSize()) {
                break;
            }

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }

    public void Clear() {

        heap = new Entrenador[this.capacity];
        heapSize = 0;
    }
}
