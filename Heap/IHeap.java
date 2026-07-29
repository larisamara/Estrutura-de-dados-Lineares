public interface IPriorityQueue<T extends Comparable<T>> {
    void insert(T element);
    T removeMin();
    T min();
    int size();
    boolean isEmpty();
}