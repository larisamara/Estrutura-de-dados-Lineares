package sequence;

import list.NoDuplo;

public class TesteSequencia {
    public static void main(String[] args) {
        System.out.println("=== TESTE: SEQUÊNCIA (Híbrida) ===");
        SequenciaLista seq = new SequenciaLista();
        
        // Uso como Vetor
        seq.insereNoIndice(0, "10");
        seq.insereNoIndice(1, "30");
        seq.insereNoIndice(1, "20"); // 10, 20, 30
        
        // Uso como Lista
        NoDuplo no = seq.noNoIndice(1); // Nó com "20"
        seq.insereDepois(no, "25");    // 10, 20, 25, 30
        
        imprimir(seq);
        
        System.out.println("Rank do elemento '25': " + seq.indiceDe(seq.proximo(no)));
        System.out.println("Elemento no índice 3: " + seq.elementoNoIndice(3));
        
        System.out.println("Removendo primeiro e último...");
        seq.remove(seq.primeiro());
        seq.removeNoIndice(seq.tamanho() - 1);
        imprimir(seq);
    }

    private static void imprimir(SequenciaLista s) {
        System.out.print("Sequência: ");
        for (int i = 0; i < s.tamanho(); i++) {
            System.out.print(s.elementoNoIndice(i) + " ");
        }
        System.out.println();
    }
}
