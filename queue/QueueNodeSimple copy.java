public class QueueNode implements IQueue {

    private Node head, tail;   // head é nó sentinela (dummy); tail aponta para o último nó

    public QueueNode() {
        head = new Node();
        head.setElement(null);        // não armazena elemento útil
        tail = head;                  // fila vazia: head e tail apontam para o mesmo nó
    }

    @Override
    public void enqueue(Object element) {
        Node novo = new Node();
        novo.setElement(element);
        novo.setNext(null);           // será o novo último

        tail.setNext(novo);           // encadeia ao final
        tail = novo;                  // atualiza a cauda
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Vazia");
        }

        Node primeiro = head.getNext();   // primeiro elemento real
        Object elemento = primeiro.getElement();

        head.setNext(primeiro.getNext()); // remove o primeiro
        if (primeiro == tail) {           // se era o único elemento, tail volta para head
            tail = head;
        }

        return elemento;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;   // ou head == tail
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Fila Vazia");
            return;
        }

        Node aux = head.getNext();       // começa pelo primeiro elemento real
        while (aux != null) {
            System.out.print(aux.getElement() + " | ");
            aux = aux.getNext();
        }
        System.out.println();
    }
}