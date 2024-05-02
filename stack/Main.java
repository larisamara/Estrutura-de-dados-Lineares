class Main {

  public static void main(String[] args) {
    IStack pilhaUm = new StackNode();
    IStack pilhaDois = new StackNode();
    pilhaUm.push(5);
    pilhaUm.push(7);
    pilhaUm.push(2);
    pilhaUm.push(6);
    pilhaUm.push(3);

    if (pilhaUm instanceof StackNode) {
      StackNode pilhaUmConcreta = (StackNode) pilhaUm;
      StackNode pilhaDoisConcreta = (StackNode) pilhaDois;
      while (pilhaUmConcreta.size() > 1) {
        int maior = pilhaUmConcreta.compararRemoverMaior();
        System.out.print(maior);
        System.out.print(", ");
        pilhaDoisConcreta.push(pilhaUmConcreta.pop());
        int menor = pilhaUmConcreta.compararRemoverMenor();
        System.out.print(menor);
        System.out.print(", ");
        pilhaDoisConcreta.push(pilhaUmConcreta.pop());
      }

      if (!pilhaUmConcreta.isEmpty()) {
        int ultimo = (Integer) pilhaUmConcreta.pop();
        System.out.print(ultimo);
      }

      System.out.println("");

      while (pilhaDoisConcreta.size() > 1) {
        int maior = pilhaDoisConcreta.compararRemoverMaior();
        System.out.print(maior);
        System.out.print(", ");
        pilhaDoisConcreta.push(pilhaDoisConcreta.pop());
        pilhaDoisConcreta.compararRemoverMenor();
        pilhaDoisConcreta.push(pilhaDoisConcreta.pop());
      }

      System.out.println("");

      if (!pilhaDoisConcreta.isEmpty()) {
        int ultimo = (Integer) pilhaDoisConcreta.pop();
        System.out.print(ultimo);
      }
    }

    System.out.println("");

    pilhaUm.push(3);
    pilhaUm.push(5);
    pilhaUm.push(1);
    pilhaUm.push(4);
    pilhaUm.push(10);
    pilhaUm.push(6);
    pilhaUm.push(8);
    if (pilhaUm instanceof StackNode) {
      StackNode pilhaUmConcreta = (StackNode) pilhaUm;
      StackNode pilhaDoisConcreta = (StackNode) pilhaDois;
      int maior = pilhaUmConcreta.compararRemoverMaior();
      System.out.print(maior);
      System.out.print(", ");
      while (pilhaUmConcreta.size() > 1) {
        System.out.print("top: " + pilhaUmConcreta.top());
        System.out.println("");
        int menor = pilhaUmConcreta.compararRemoverMenor();
        pilhaDoisConcreta.push(pilhaUmConcreta.pop());
        System.out.print(menor);
        System.out.print(", ");
      }



      if (!pilhaUmConcreta.isEmpty()) {
        int ultimo = (Integer) pilhaUmConcreta.pop();
        pilhaDois.push(ultimo);
      }


      while (pilhaDoisConcreta.size() > 1) {
        System.out.println(pilhaDoisConcreta.pop());
      }

      System.out.println("");

      if (!pilhaDoisConcreta.isEmpty()) {
        int ultimo = (Integer) pilhaDoisConcreta.pop();
        System.out.print(ultimo);
      }
    }
  }
}
