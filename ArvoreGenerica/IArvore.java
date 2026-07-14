interface IGenericTree<T> {
    boolean isEmpty();
    TreeNode<T> search(T data);
    boolean insert(T parentData, T childData);
    boolean remove(T data);
    List<T> preOrder();
    List<T> postOrder();
    List<T> breadthFirst();
    void print();
    int size();
}