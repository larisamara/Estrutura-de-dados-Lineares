import java.util.LinkedList;
import java.util.Queue;

/**
 * Interface que define o contrato de uma Fila de Prioridade.
 * @param <T> tipo dos elementos, deve ser comparável (ordem natural).
 */
interface IPriorityQueue<T extends Comparable<T>> {
    /**
     * Insere um elemento na fila de prioridade.
     * @param element elemento a ser inserido
     */
    void insert(T element);

    /**
     * Remove e retorna o menor elemento (raiz do heap).
     * @return o menor elemento
     * @throws RuntimeException se a fila estiver vazia
     */
    T removeMin();

    /**
     * Retorna o menor elemento sem removê-lo.
     * @return o menor elemento
     * @throws RuntimeException se a fila estiver vazia
     */
    T min();

    /**
     * Retorna o número de elementos na fila.
     * @return tamanho atual
     */
    int size();

    /**
     * Verifica se a fila está vazia.
     * @return true se vazia, false caso contrário
     */
    boolean isEmpty();
}

/**
 * Classe que representa um nó da árvore binária.
 * Cada nó guarda um valor, referências para os filhos (esquerdo e direito) e para o pai.
 * @param <T> tipo do dado armazenado
 */
class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
/** 
class Node<T> {
    T data;
    Node<T> left, right, parent;
    public Node(T data) { this.data = data; }
}
*/
    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
}

/**
 * Implementação de uma Fila de Prioridade usando um Heap binário representado
 * por uma árvore binária encadeada com nós.
 * A árvore mantém a propriedade de heap (menor elemento na raiz) e é completa
 * (preenchida por níveis, da esquerda para a direita).
 * @param <T> tipo dos elementos, deve ser comparável
 */
class PriorityQueueHeap<T extends Comparable<T>> implements IPriorityQueue<T> {
    private Node<T> root;
    private int size;

    public PriorityQueueHeap() {
        root = null;
        size = 0;
    }

    // ---------- Implementação da interface ----------

    @Override
    public void insert(T element) {
        Node<T> newNode = new Node<>(element);

        if (root == null) {
            root = newNode;
        } else {
            // Encontra o próximo nó disponível (primeiro nó com um filho nulo)
            Node<T> parent = findNextAvailableParent();
            if (parent.left == null) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;
        }
        size++;
        // Restaura a propriedade de heap subindo
        heapifyUp(newNode);
    }

    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new RuntimeException("Fila de prioridade vazia.");
        }

        if (size == 1) {
            T min = root.data;
            root = null;
            size--;
            return min;
        }

        // Encontra o último nó (o mais à direita no último nível)
        Node<T> lastNode = findLastNode();

        // Substitui a raiz pelo valor do último nó
        T min = root.data;
        root.data = lastNode.data;

        // Remove o último nó da árvore
        removeLastNode(lastNode);

        size--;
        // Restaura a propriedade de heap descendo
        heapifyDown(root);

        return min;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            throw new RuntimeException("Fila de prioridade vazia.");
        }
        return root.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // ---------- Métodos auxiliares privados ----------

    /**
     * Encontra o primeiro nó (em BFS) que tenha pelo menos um filho nulo.
     * Esse nó será o pai do novo nó a ser inserido.
     */
    private Node<T> findNextAvailableParent() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if (current.left == null || current.right == null) {
                return current;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
        return null; // nunca deve ocorrer
    }

    /**
     * Encontra o último nó da árvore (o mais à direita no último nível,
     * conforme a ordem de inserção). Utiliza BFS e retorna o último visitado.
     */
    private Node<T> findLastNode() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        Node<T> last = null;

        while (!queue.isEmpty()) {
            last = queue.poll();
            if (last.left != null) queue.add(last.left);
            if (last.right != null) queue.add(last.right);
        }
        return last;
    }

    /**
     * Remove o último nó da árvore, atualizando a referência do pai.
     */
    private void removeLastNode(Node<T> last) {
        Node<T> parent = last.parent;
        if (parent != null) {
            if (parent.left == last) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // last não terá mais referências (será coletado pelo GC)
    }

    /**
     * Restaura a propriedade de heap subindo a partir de um nó.
     * Troca com o pai enquanto o pai for maior.
     */
    private void heapifyUp(Node<T> node) {
        while (node.parent != null && node.data.compareTo(node.parent.data) < 0) {
            // Troca os dados (não os nós)
            T temp = node.data;
            node.data = node.parent.data;
            node.parent.data = temp;
            node = node.parent; // sobe
        }
    }

    /**
     * Restaura a propriedade de heap descendo a partir de um nó.
     * Troca com o menor filho enquanto o filho for menor.
     */
    private void heapifyDown(Node<T> node) {
        while (node != null) {
            Node<T> smallest = node;
            Node<T> left = node.left;
            Node<T> right = node.right;

            if (left != null && left.data.compareTo(smallest.data) < 0) {
                smallest = left;
            }
            if (right != null && right.data.compareTo(smallest.data) < 0) {
                smallest = right;
            }

            if (smallest == node) {
                break; // propriedade satisfeita
            }

            // Troca os dados
            T temp = node.data;
            node.data = smallest.data;
            smallest.data = temp;
            node = smallest; // desce
        }
    }

    // ---------- Métodos extras (para depuração/visualização) ----------

    /**
     * Exibe a árvore de forma hierárquica (rotacionada).
     */
    public void print() {
        if (root == null) {
            System.out.println("Heap vazio.");
            return;
        }
        System.out.println("Estrutura do Heap (rotacionado):");
        printRec(root, 0);
        System.out.println();
    }

    private void printRec(Node<T> node, int level) {
        if (node == null) return;
        printRec(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        printRec(node.left, level + 1);
    }
}
