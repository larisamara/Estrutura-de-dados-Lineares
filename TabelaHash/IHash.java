interface IHashTable<K, V> {
    void insert(K key, V value);
    V search(K key);
    V remove(K key);
    int size();
    boolean isEmpty();
    void clear();
    double getLoadFactor();
}