public class QueueNodeDoubly implements IQueue {

    private Node head, tail;

    public QueueNodeDoubly() {
        head = new Node(null);   // nó sentinela (dummy)
        tail = head;             // fila vazia
    }

    // Classe interna representando o nó com dois ponteiros
    private static class Node {
        Object element;
        Node next;
        Node prev;

        Node(Object element) {
            this.element = element;
        }
    }

    @Override
    public void enqueue(Object element) {
        Node novo = new Node(element);
        novo.prev = tail;
        tail.next = novo;
        tail = novo;             // atualiza a cauda
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Vazia");
        }

        Node primeiro = head.next;   // primeiro elemento real
        Object elemento = primeiro.element;

        head.next = primeiro.next;   // desencadeia o primeiro

        if (primeiro.next != null) {
            primeiro.next.prev = head; // ajusta o prev do novo primeiro para o head
        } else {
            tail = head;              // se era o único, fila fica vazia
        }

        // (opcional) limpa referências do nó removido para ajudar o GC
        primeiro.next = null;
        primeiro.prev = null;

        return elemento;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;    // ou head == tail
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Fila Vazia");
            return;
        }

        Node aux = head.next;        // começa pelo primeiro elemento real
        while (aux != null) {
            System.out.print(aux.element + " | ");
            aux = aux.next;
        }
        System.out.println();
    }
}