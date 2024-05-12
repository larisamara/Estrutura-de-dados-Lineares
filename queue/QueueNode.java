public class QueueNode implements IQueue {

  private Node head, tail;

  QueueNode() {
    head = new Node();
    head.setElement("head");
    tail = new Node();
    tail.setElement("tail");
  }

  public void enqueue(Object element) {
    Node n = new Node();
    n.setElement(element);
    if (head.getNext() == null) {
      head.setNext(n);
      n.setNext(tail);
    } else {
      Node next = new Node();
      next = head.getNext();
      while(next.getNext() != tail) {
        next = next.getNext();
      }
      next.setNext(n);
      n.setNext(tail);
    }
  }

  public Object dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Fila Vazia");
    }
    Node first = head.getNext();
    Object o = first.getElement();
    head.setNext(first.getNext());
    return o;
  }

  public void print() {
    if (head == null) {
      System.out.println("Fila Vazia");
    } else {
      Node aux = head;
      while (aux != tail.getNext()) {
        System.out.print(aux.getElement() + " | ");
        aux = aux.getNext();
      }
      System.out.println("");
    }
  }

  public boolean isEmpty() {
    return this.head == null;
  }
}