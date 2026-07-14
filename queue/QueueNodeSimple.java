public class QueueNode implements IQueue {

    private Node head, tail;  

    public QueueNode() {
        head = new Node();
        head.setElement(null);        
        tail = head;                  
    }

    @Override
    public void enqueue(Object element) {
        Node novo = new Node();
        novo.setElement(element);
        novo.setNext(null);          

        tail.setNext(novo);           
        tail = novo;                  
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Vazia");
        }

        Node primeiro = head.getNext();   
        Object elemento = primeiro.getElement();

        head.setNext(primeiro.getNext());
        if (primeiro == tail) {           
            tail = head;
        }

        return elemento;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;  
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Fila Vazia");
            return;
        }

        Node aux = head.getNext();      
        while (aux != null) {
            System.out.print(aux.getElement() + " | ");
            aux = aux.getNext();
        }
        System.out.println();
    }
}