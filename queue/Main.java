/*
 * Questão 03 (original) - TADs Fila e Pilha utilizando a estrutura de dados concreta lista simplesmente encadeada.
 * Questão 07 (alterada) - IMPLEMENTE EM JAVA/C# o TAD Fila, utilizando duas pilhas
 * Questão 08 (alterada) - IMPLEMENTE EM JAVA/C# o TAD Pilha, utilizando duas filas
 * Nova Questão -  IMPLEMENTE EM JAVA/C# o TAD Pilha utilizando uma Lista Simplesmente Encadeada.
 */
class Main {

  public static void main(String[] args) {
    System.out.println("Queue With Node");
    IQueue fila = new QueueNode();
    fila.enqueue("Larissa");
    fila.print();
    fila.enqueue("Samara");
    fila.print();
    fila.enqueue("Xavier");
    fila.print();
    fila.dequeue();
    fila.print();
    
    System.out.println("");
    System.out.println("Queue With Two Stacks");

    fila = new QueueTwoStack();
    fila.enqueue("Larissa");
    fila.print();
    fila.enqueue("Samara");
    fila.print();
    fila.enqueue("Xavier");
    fila.print();
    fila.dequeue();
    fila.print();
  }
}
