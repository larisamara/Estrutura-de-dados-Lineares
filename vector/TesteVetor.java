package vector;

public class TesteVetor {
    public static void main(String[] args) {
        System.out.println("=== TESTE: VETOR (Arranjo Dinâmico) ===");
        IVetor vetor = new VetorArranjo(2); // Começa pequeno para testar redimensionamento
        
        vetor.insereNoIndice(0, "João");
        vetor.insereNoIndice(1, "Maria");
        vetor.insereNoIndice(1, "Pedro"); // João, Pedro, Maria (provoca redimensionamento)
        
        imprimir(vetor);
        
        System.out.println("Substituindo índice 0 por 'Ana'...");
        vetor.substituiNoIndice(0, "Ana");
        imprimir(vetor);
        
        System.out.println("Removendo índice 1 ('Pedro')...");
        vetor.removeNoIndice(1);
        imprimir(vetor);
        
        System.out.println("Elemento no índice 1: " + vetor.elementoNoIndice(1));
        System.out.println("Tamanho: " + vetor.tamanho());
    }

    private static void imprimir(IVetor v) {
        System.out.print("Vetor: ");
        for (int i = 0; i < v.tamanho(); i++) {
            System.out.print(v.elementoNoIndice(i) + " ");
        }
        System.out.println();
    }
}
