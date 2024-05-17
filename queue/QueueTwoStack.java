public class QueueTwoStack implements IQueue {
    private StackNode pilhaEntrada;
    private StackNode pilhaSaida;

    public QueueTwoStack() {
        this.pilhaEntrada = new StackNode();
        this.pilhaSaida = new StackNode();
    }

    public void enqueue(Object valor) {
        pilhaEntrada.push(valor);
    }

    public Object dequeue() {
        if (pilhaSaida.isEmpty()) {
            encherPilhaSaida();
        }
        return pilhaSaida.pop();
    }

    public boolean isEmpty() {
        return pilhaEntrada.isEmpty() && pilhaSaida.isEmpty();
    }

    public void print() {
        while (!pilhaSaida.isEmpty()) {
            System.out.print(dequeue());
            System.out.print("|");
        }
    }

    private void encherPilhaSaida() {
        while (!pilhaEntrada.isEmpty()) {
            pilhaSaida.push(pilhaEntrada.pop());
        }
    }
}