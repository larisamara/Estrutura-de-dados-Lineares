public class Stack implements IStack {

  private Object stack[];
  private int topStack = -1;
  public static int capacityStack = 1;

  public Stack() {
    this(capacityStack);
  }

  public Stack(int qtdPositions) {
    capacityStack = qtdPositions;
    stack = new Object[capacityStack];
  }

  @Override
  public int size() {
    return topStack + 1;
  }

  @Override
  public boolean isEmpty() {
    return (topStack < 0);
  }

  @Override
  public Object top() {
    if (isEmpty()) {
      return "Stack is Empty";
    } else {
      return stack[topStack];
    }
  }

  public void duplicate() {
    int newCapacity = capacityStack * 2;
    Object newStack[] = new Object[newCapacity];
    for (int i = 0; i < stack.length; i++) {
      newStack[i] = stack[i];
    }
    stack = newStack;
    capacityStack = newCapacity;
  }

  public void reduce() {
    int newCapacity = capacityStack / 2;
    Object newStack[] = new Object[newCapacity];
    for (int i = 0; i < newStack.length; i++) {
      newStack[i] = stack[i];
    }
    stack = newStack;
    capacityStack = newCapacity;
  }

  @Override
  public void push(Object item) {
    isStackFull();
    int position = ++topStack;
    stack[position] = item;
    System.out.println("Insert Item: " + item);
  }

  public void isStackFull() {
    int sizeStack = stack.length;
    if (size() == sizeStack) { // verifica se a pilha ta cheia
      duplicate();
    }
  }

  public void isPercentsEmpty() {
    int sizeStack = stack.length;
    int result = (sizeStack * 25) / 100;
    if (result == topStack) {
      reduce();
    }
  }

  @Override
  public Object pop() {
    if (isEmpty()) {
      return "Stack is Empty";
    } else {
      isPercentsEmpty();
      Object o = stack[topStack];
      int position = topStack--;
      stack[position] = null;
      return o;
    }
  }
}
