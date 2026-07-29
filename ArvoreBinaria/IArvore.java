import java.util.Iterator;

public interface IArvore<E> {

    interface No<E> {
        E getElement();
    }

    int size();
    int height();
    boolean isEmpty();
    Iterator<E> elements();
    Iterator<No<E>> nos();
    No<E> root();
    No<E> parent(No<E> n);
    Iterator<No<E>> children(No<E> n);
    boolean isInternal(No<E> n);
    boolean isExternal(No<E> n);
    boolean isRoot(No<E> n);
    int depth(No<E> n);
    E replace(No<E> n, E o);
}