// Classe Main para testes
public class Main {
    public static void main(String[] args) {
        // Definição das constantes
        final int IDADE = 30;
        final double ALTURA = 1.74;

        IQueue fila = new QueueNode();

        // Testa isEmpty() no início
        System.out.println("A fila está vazia? " + fila.isEmpty()); // true

        // Enfileira os nomes e as constantes
        System.out.println("\n--- Enfileirando elementos ---");
        fila.enqueue("Larissa");
        fila.enqueue("Samara");
        fila.enqueue("Xavier");
        fila.enqueue(IDADE);   // 30
        fila.enqueue(ALTURA);  // 1.74
        System.out.print("Fila após enfileirar: ");
        fila.print();          // Esperado: Larissa | Samara | Xavier | 30 | 1.74 |

        // Testa dequeue
        System.out.println("\n--- Desenfileirando ---");
        Object removido = fila.dequeue();
        System.out.println("Elemento removido: " + removido); // Larissa
        System.out.print("Fila após remover: ");
        fila.print();          // Esperado: Samara | Xavier | 30 | 1.74 |

        removido = fila.dequeue();
        System.out.println("Elemento removido: " + removido); // Samara
        System.out.print("Fila após remover: ");
        fila.print();          // Esperado: Xavier | 30 | 1.74 |

        System.out.println("\nA fila está vazia? " + fila.isEmpty()); // false
    }
}