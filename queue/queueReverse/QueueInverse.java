public class QueueInverse implements IQueue {
    private Object[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;
    private boolean invertida;

    private static final int CAPACIDADE_MINIMA = 4;

    public QueueInverse() {
        this.capacidade = CAPACIDADE_MINIMA;
        this.elementos = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
        this.invertida = false;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public void enqueue(Object o) {
        if (tamanho == capacidade) {
            redimensionar(capacidade * 2);
        }

        if (!invertida) {
            elementos[fim] = o;
            fim = (fim + 1) % capacidade;
        } else {
            inicio = (inicio - 1 + capacidade) % capacidade;
            elementos[inicio] = o;
        }
        tamanho++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        Object item;
        if (!invertida) {
            item = elementos[inicio];
            elementos[inicio] = null;
            inicio = (inicio + 1) % capacidade;
        } else {
            fim = (fim - 1 + capacidade) % capacidade;
            item = elementos[fim];
            elementos[fim] = null;
        }
        tamanho--;

        if (capacidade > CAPACIDADE_MINIMA && tamanho <= capacidade / 3) {
            redimensionar(capacidade / 2);
        }

        return item;
    }

    public void reverse() {
        invertida = !invertida; //false or true
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(getLogico(i));
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public Object front() {
        return isEmpty() ? null : getLogico(0);
    }

    public Object back() {
        return isEmpty() ? null : getLogico(tamanho - 1);
    }

    private Object getLogico(int i) {
        int indiceFisico;
        if (!invertida) {
            indiceFisico = (inicio + i) % capacidade;
        } else {
            indiceFisico = (fim - 1 - i + capacidade) % capacidade;
        }
        return elementos[indiceFisico];
    }

    private void redimensionar(int novaCapacidade) {
        if (novaCapacidade < CAPACIDADE_MINIMA) {
            novaCapacidade = CAPACIDADE_MINIMA;
        }

        Object[] novoArray = new Object[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = getLogico(i);
        }

        this.elementos = novoArray;
        this.capacidade = novaCapacidade;
        this.inicio = 0;
        this.fim = tamanho;
        this.invertida = false;
    }

    public int size() { return tamanho; }
    public int capacity() { return capacidade; }
    public boolean isReversed() { return invertida; }
}
