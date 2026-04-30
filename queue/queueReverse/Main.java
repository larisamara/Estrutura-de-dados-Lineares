public class Main {
    public static void main(String[] args) {
        QueueInverse q = new QueueInverse();
        
        System.out.println("--- Teste 1: Operações Básicas e Reversão O(1) ---");
        q.enqueue("A"); q.enqueue("B"); q.enqueue("C");
        q.print(); // [A, B, C]
        
        q.reverse();
        System.out.print("Após Reverse: "); q.print(); // [C, B, A]
        System.out.println("Dequeue (esperado C): " + q.dequeue());
        q.enqueue("D");
        System.out.print("Após Enqueue D: "); q.print(); // [B, A, D]

        System.out.println("\n--- Teste 2: Redimensionamento Dinâmico ---");
        QueueInverse q2 = new QueueInverse(); // Cap: 4
        for (int i = 1; i <= 5; i++) q2.enqueue(i);
        System.out.println("Tamanho 5, Capacidade: " + q2.capacity()); // Deve ser 8
        q2.print();

        System.out.println("Removendo para testar Shrink (1/3)...");
        while (q2.size() > 2) q2.dequeue();
        System.out.println("Tamanho 2, Capacidade: " + q2.capacity()); // Deve ser 4
        q2.print();

        System.out.println("\n--- Teste 3: Consistência Pós-Shrink ---");
        q2.reverse();
        q2.enqueue("Fim");
        q2.print();
        
        System.out.println("\nValidação concluída.");
    }
}
