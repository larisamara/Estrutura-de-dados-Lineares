public class StackNode implements IStack{
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