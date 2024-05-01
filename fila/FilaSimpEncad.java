public class FilaSimpEncad implements IFilaSimpEncad {

  private Node head, tail;

  public FilaSimpEncad() {
    head = null;
    tail = null;
  }

  public void enfileirar(Object element) {
    Node n = new Node();
    n.setElement(element);
    n.setNext(null);
    if (head == null) {
      head = n;
      tail = n;
    } else {
      tail.setNext(n);
      tail = n;
    }
  }

  public Object desenfileirar() {
    if (isEmpty()) {
      throw new RuntimeException("Fila Vazia");
    }
    Node aux = head;
    Object o = aux.getElement();
    head = aux.getNext();
    return o;
  }

  public void mostrar() {
    if (head == null) {
      System.out.println("Fila Vazia");
    } else {
      Node aux = head;
      while (aux != null) {
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