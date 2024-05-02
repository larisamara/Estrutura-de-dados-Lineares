public class StackNode implements IStack {

  private Node topo;
  private int size = 0;

  public StackNode() {
    this.topo = null;
  }

  public void push(Object valor) {
    Node novoNo = new Node();
    novoNo.setElement(valor);
    novoNo.setNext(topo);
    topo = novoNo;
    size++;
  }

  public Object pop() {
    if (this.topo == null) {
      throw new RuntimeException("A pilha está vazia.");
    }
    Object valor = topo.getElement();
    topo = topo.getNext();
    size--;
    return valor;
  }

  public int compararRemoverMaior() {
    if (topo == null || topo.getNext() == null) {
      return -1; // colocar exceção
    }

    int maior;

    if ((Integer) topo.getElement() > (Integer) topo.getNext().getElement()) {
      maior = (Integer) pop();
    } else {
      int temp = (Integer) pop();
      maior = (Integer) pop();
      push(temp);
    }

    return maior;
  }

  public int compararRemoverMenor() {
    if (topo == null || topo.getNext() == null) {
      return -1; // Ou lance uma exceção para indicar pilha com menos de dois elementos
    }

    int menor;

    if ((Integer) topo.getElement() < (Integer) topo.getNext().getElement()) {
      menor = (Integer) pop();
    } else {
      int temp = (Integer) pop();
      menor = (Integer) pop();
      push(temp);
    }

    return menor;
  }

  public boolean isEmpty() {
    return topo == null;
  }

  @Override
  public Object top() {
    if (isEmpty()) {
      return "Stack is Empty";
    } else {
      return topo.getElement();
    }
  }

  public int size() {
    return size;
  }
}
