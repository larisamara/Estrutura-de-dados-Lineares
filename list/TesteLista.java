package list;

public class TesteLista {
    public static void main(String[] args) {
        System.out.println("=== TESTE: LISTA POSICIONAL (Encadeada) ===");
        ILista lista = new ListaEncadeada();
        
        System.out.println("Está vazia? " + lista.estaVazia());
        
        NoDuplo p1 = lista.inserePrimeiro("A"); // A
        NoDuplo p2 = lista.insereUltimo("C");   // A, C
        lista.insereDepois(p1, "B");            // A, B, C
        lista.insereAntes(p2, "D");             // A, B, D, C
        
        imprimir(lista);
        
        System.out.println("Removendo 'B'...");
        lista.remove(lista.proximo(p1));
        imprimir(lista);
        
        System.out.println("Trocando primeiro com último...");
        lista.troca(lista.primeiro(), lista.ultimo());
        imprimir(lista);
        
        System.out.println("Tamanho final: " + lista.tamanho());
    }

    private static void imprimir(ILista l) {
        System.out.print("Lista: ");
        NoDuplo atual = l.primeiro();
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = l.proximo(atual);
        }
        System.out.println();
    }
}
