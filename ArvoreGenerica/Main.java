
public class Main {
    public static void main(String[] args) {
        GenericTree<String> tree = new GenericTree<>();

        System.out.println("--- Inserindo (Ana → Joel → Larissa → Maykon) ---");
        tree.insert(null, "Ana");       
        tree.insert("Ana", "Joel");     
        tree.insert("Joel", "Larissa"); 
        tree.insert("Larissa", "Maykon"); 

        System.out.println("Árvore gerada:");
        tree.print();

        System.out.println("\n--- Buscas ---");
        System.out.println("Ana: "     + (tree.search("Ana")     != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Joel: "    + (tree.search("Joel")    != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Larissa: " + (tree.search("Larissa") != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Maykon: "  + (tree.search("Maykon")  != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Carlos: "  + (tree.search("Carlos")  != null ? "Encontrado" : "Não encontrado"));

        System.out.println("\n--- Percursos ---");
        System.out.println("Pré‑ordem: " + tree.preOrder());
        System.out.println("Pós‑ordem: " + tree.postOrder());
        System.out.println("Largura:   " + tree.breadthFirst());

        System.out.println("\n--- Remoção ---");
        System.out.println("Remover Larissa (e sua subárvore): " + tree.remove("Larissa"));
        System.out.println("Árvore após remover Larissa:");
        tree.print();

        System.out.println("\n--- Informações ---");
        System.out.println("Tamanho: " + tree.size());
        System.out.println("Vazia?   " + tree.isEmpty());

        System.out.println("\nRemover raiz Ana: " + tree.remove("Ana"));
        System.out.println("Árvore após remover raiz:");
        tree.print();
        System.out.println("Vazia? " + tree.isEmpty());
    }
}