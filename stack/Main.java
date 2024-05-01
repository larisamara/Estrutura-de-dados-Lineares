class Main {

  public static void main(String[] args) {
    IStack stack = new Stack();
    stack.push(5);
    stack.push(7);
    stack.push(2);
    stack.push(6);
    stack.push(3);
    stack.push(11);
    System.out.println("");

    int i = 0;
    do {
      Object element = stack.pop();
      System.out.println(element);
      i++;
    } while (i <= stack.size());

    System.out.println("");

    IStack stackNode = new StackNode();
    stackNode.push("Larissa");
    stackNode.push("Xavier");
    System.out.println(stackNode.pop());
    System.out.println(stackNode.pop());

  }
}
