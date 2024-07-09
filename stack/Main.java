class Main {

  public static void main(String[] args) {
    IStack pilhaUm = new StackNode();
    IStack pilhaDois = new StackNode();
    pilhaUm.push(3);
    pilhaUm.push(6);
    pilhaUm.push(2);
    pilhaUm.push(7);
    pilhaUm.push(5);
    int atual = 0;
    while (pilhaUm.size() > 0) {
      Object item = pilhaUm.pop();
      //System.out.println(atual);
      //System.out.println(item);
      if ((int) item < atual) {
        System.out.println(item);
        atual = (int) item;
      }
    }
  }
}
