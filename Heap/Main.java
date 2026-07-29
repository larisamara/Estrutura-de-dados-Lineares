
/**
 * Classe de testes para demonstrar o funcionamento da Fila de Prioridade.
 */
public class Main {
    public static void main(String[] args) {
        IPriorityQueue<Integer> pq = new PriorityQueueHeap<>();

        System.out.println("--- Inserindo elementos: 10, 20, 5, 15, 30, 1 ---");
        pq.insert(10);
        pq.insert(20);
        pq.insert(5);
        pq.insert(15);
        pq.insert(30);
        pq.insert(1);

        // Exibe a estrutura do heap
        ((PriorityQueueHeap<Integer>) pq).print();

        System.out.println("Tamanho: " + pq.size());
        System.out.println("Mínimo: " + pq.min());

        System.out.println("\n--- Removendo mínimo ---");
        System.out.println("Removido: " + pq.removeMin());
        ((PriorityQueueHeap<Integer>) pq).print();

        System.out.println("Removido: " + pq.removeMin());
        ((PriorityQueueHeap<Integer>) pq).print();

        System.out.println("Removido: " + pq.removeMin());
        ((PriorityQueueHeap<Integer>) pq).print();

        System.out.println("Tamanho restante: " + pq.size());

        System.out.println("\n--- Inserindo 3 e 7 ---");
        pq.insert(3);
        pq.insert(7);
        ((PriorityQueueHeap<Integer>) pq).print();

        System.out.println("Mínimo atual: " + pq.min());

        // Esvazia a fila
        System.out.println("\n--- Removendo todos os elementos ---");
        while (!pq.isEmpty()) {
            System.out.println("Removido: " + pq.removeMin());
            ((PriorityQueueHeap<Integer>) pq).print();
        }

        // Tentativa de remover de fila vazia
        try {
            pq.removeMin();
        } catch (RuntimeException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
}