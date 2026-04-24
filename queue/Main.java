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
    fila.enqueue("Samara");
    fila.enqueue("Xavier");
    fila.print();
    // Criando fila com capacidade 5
        CircularArrayQueue queue = new CircularArrayQueue(5);
        
        System.out.println("=== Testando Fila com Array Circular ===");
        
        // Inserindo elementos
        System.out.println("\nInserindo elementos:");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.print();
        
        // Removendo elementos
        System.out.println("\nRemovendo elemento: " + queue.dequeue());
        queue.print();
        
        // Inserindo mais elementos (testa comportamento circular)
        System.out.println("\nInserindo mais elementos:");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.print();
        
        // Verificando se está cheia
        System.out.println("\nEstá cheia? " + queue.isFull());
        
        // Tentando inserir em fila cheia
        try {
            queue.enqueue("G");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Removendo todos os elementos
        System.out.println("\nEsvaziando a fila:");
        while (!queue.isEmpty()) {
            System.out.println("Removido: " + queue.dequeue());
            queue.print();
        }
        
        // Testando peek
        CircularArrayQueue queue2 = new CircularArrayQueue(3);
        queue2.enqueue("X");
        queue2.enqueue("Y");
        System.out.println("\nPrimeiro elemento (peek): " + queue2.peek());
        queue2.print();
  }
}
