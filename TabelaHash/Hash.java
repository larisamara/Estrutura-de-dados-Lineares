import java.util.LinkedList;

/**
 * Enum que define as estratégias de tratamento de colisão.
 */
enum ProbingType {
    LINEAR,       // Sondagem linear
    DOUBLE_HASH   // Hash duplo
}

/**
 * Classe que representa uma entrada (par chave-valor) da tabela.
 * Possui também um flag "deleted" para suportar remoção com sondagem.
 */
class Entry<K, V> {
    K key;
    V value;
    boolean deleted;  // marcador de remoção lógica

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

/**
 * Implementação de uma Tabela Hash com tratamento de colisões por
 * sondagem linear ou hash duplo. A tabela realiza rehash automaticamente
 * quando o fator de carga ultrapassa 0,75.
 * @param <K> tipo da chave
 * @param <V> tipo do valor
 */
public class HashTable<K, V> implements IHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double MAX_LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    private ProbingType probingType;
    private final int primeForDoubleHash = 7; // número primo para segunda hash

    /**
     * Construtor padrão com capacidade inicial 16 e sondagem linear.
     */
    public HashTable() {
        this(DEFAULT_CAPACITY, ProbingType.LINEAR);
    }

    /**
     * Construtor que permite escolher a capacidade inicial e a estratégia de sondagem.
     * @param initialCapacity capacidade inicial (será ajustada para o próximo primo)
     * @param probingType tipo de sondagem (LINEAR ou DOUBLE_HASH)
     */
    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity, ProbingType probingType) {
        // Usamos um tamanho primo para melhor distribuição
        this.capacity = nextPrime(initialCapacity);
        this.table = new Entry[this.capacity];
        this.size = 0;
        this.probingType = probingType;
    }

    // ---------- Métodos auxiliares de hash ----------

    /**
     * Função hash primária.
     */
    private int hash1(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Função hash secundária para hash duplo.
     * Retorna um valor ímpar e positivo, garantindo que seja primo relativo à capacidade.
     */
    private int hash2(K key) {
        return primeForDoubleHash - (Math.abs(key.hashCode()) % primeForDoubleHash);
    }

    /**
     * Calcula o incremento (passo) para a sondagem, baseado na estratégia escolhida.
     * @param key chave
     * @param attempt número da tentativa (0, 1, 2, ...)
     * @return o deslocamento a partir da posição inicial
     */
    private int getProbeStep(K key, int attempt) {
        if (probingType == ProbingType.LINEAR) {
            return attempt; // passo 1, 2, 3...
        } else { // DOUBLE_HASH
            return attempt * hash2(key);
        }
    }

    /**
     * Verifica se uma posição da tabela está livre (nula ou marcada como deletada).
     */
    private boolean isSlotAvailable(int index) {
        return table[index] == null || table[index].deleted;
    }

    /**
     * Retorna o próximo número primo maior ou igual a n.
     */
    private int nextPrime(int n) {
        while (!isPrime(n)) n++;
        return n;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // ---------- Métodos principais ----------

    @Override
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Chave não pode ser nula.");
        }

        // Verifica se o fator de carga excedeu o limite e faz rehash se necessário
        if (getLoadFactor() >= MAX_LOAD_FACTOR) {
            rehash();
        }

        int index = hash1(key);
        int attempt = 0;
        int step;

        // Procura por uma posição disponível (vazia ou deletada) ou a chave já existente
        while (true) {
            int currentIndex = (index + getProbeStep(key, attempt)) % capacity;

            if (table[currentIndex] == null) {
                // Posição vazia: insere
                table[currentIndex] = new Entry<>(key, value);
                size++;
                return;
            } else if (table[currentIndex].deleted) {
                // Posição marcada como deletada: pode ser reutilizada
                table[currentIndex] = new Entry<>(key, value);
                size++;
                return;
            } else if (table[currentIndex].key.equals(key)) {
                // Atualiza valor existente (não incrementa size)
                table[currentIndex].value = value;
                return;
            }
            attempt++;
            // Segurança: evita loop infinito (nunca deve ocorrer se a tabela não estiver cheia)
            if (attempt >= capacity) {
                throw new RuntimeException("Tabela hash cheia (não deveria ocorrer com rehash).");
            }
        }
    }

    @Override
    public V search(K key) {
        if (key == null) return null;

        int index = hash1(key);
        int attempt = 0;
        int step;

        while (attempt < capacity) {
            int currentIndex = (index + getProbeStep(key, attempt)) % capacity;

            if (table[currentIndex] == null) {
                // Se encontrou um buraco vazio, a chave não existe
                return null;
            } else if (!table[currentIndex].deleted && table[currentIndex].key.equals(key)) {
                return table[currentIndex].value;
            }
            attempt++;
        }
        return null; // chave não encontrada
    }

    @Override
    public V remove(K key) {
        if (key == null) return null;

        int index = hash1(key);
        int attempt = 0;
        int step;

        while (attempt < capacity) {
            int currentIndex = (index + getProbeStep(key, attempt)) % capacity;

            if (table[currentIndex] == null) {
                // Não encontrou a chave
                return null;
            } else if (!table[currentIndex].deleted && table[currentIndex].key.equals(key)) {
                // Marca como deletado e retorna o valor
                table[currentIndex].deleted = true;
                size--;
                return table[currentIndex].value;
            }
            attempt++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public double getLoadFactor() {
        return (double) size / capacity;
    }

    /**
     * Realiza o rehash: dobra a capacidade e reinsere todos os elementos ativos.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        int newCapacity = nextPrime(capacity * 2);
        Entry<K, V>[] oldTable = table;
        int oldCapacity = capacity;

        // Nova tabela
        table = new Entry[newCapacity];
        capacity = newCapacity;
        size = 0; // será recalculado durante a reinserção

        // Reinsere todas as entradas não deletadas
        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> entry = oldTable[i];
            if (entry != null && !entry.deleted) {
                insert(entry.key, entry.value);
            }
        }
    }

    // ---------- Método para impressão da tabela (auxiliar) ----------

    public void printTable() {
        System.out.println("Tabela Hash (capacidade=" + capacity + ", tamanho=" + size + ", fator=" + getLoadFactor() + ")");
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                System.out.printf("[%2d] null%n", i);
            } else if (table[i].deleted) {
                System.out.printf("[%2d] DELETED (chave=%s)%n", i, table[i].key);
            } else {
                System.out.printf("[%2d] %s%n", i, table[i]);
            }
        }
        System.out.println();
    }
}