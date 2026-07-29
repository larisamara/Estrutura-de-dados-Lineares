interface IArvoreBinaria<T extends Comparable<T>> {
    void insert(T value);
    boolean remove(T value);
    Node<T> search(T value);
    List<T> inorder();
    List<T> preorder();
    List<T> postorder();
    int height();
    int size();
    T min();
    T max();
    T successor(T value);
    T predecessor(T value);
    boolean isEmpty();
    void show();
}