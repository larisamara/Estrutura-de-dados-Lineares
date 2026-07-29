/**
 * Classe de testes para a BST.
 * Utiliza Integer como tipo concreto.
 */
public class Main {
    public static void main(String[] args) {
        IBinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Inserções iniciais
        System.out.println("--- Inserindo: 10, 5, 15, 2, 8, 22 ---");
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(8);
        bst.insert(22);
        bst.show();
        System.out.println("Em ordem: " + bst.inorder());
        System.out.println("Altura: " + bst.height() + " | Tamanho: " + bst.size());

        // Inserir 25
        System.out.println("\n--- Inserindo 25 ---");
        bst.insert(25);
        bst.show();

        // Remover 5
        System.out.println("\n--- Removendo 5 ---");
        bst.remove(5);
        bst.show();
        System.out.println("Em ordem: " + bst.inorder());

        // Remover 10 (raiz)
        System.out.println("\n--- Removendo 10 ---");
        bst.remove(10);
        bst.show();

        // Métodos adicionais
        System.out.println("\n--- Métodos adicionais ---");
        System.out.println("Mínimo: " + bst.min());
        System.out.println("Máximo: " + bst.max());
        System.out.println("Sucessor de 8: " + bst.successor(8));
        System.out.println("Predecessor de 22: " + bst.predecessor(22));
        System.out.println("Buscar 15: " + (bst.search(15) != null ? "encontrado" : "não encontrado"));
        System.out.println("Buscar 99: " + (bst.search(99) != null ? "encontrado" : "não encontrado"));

        // Percursos
        System.out.println("Pré-ordem: " + bst.preorder());
        System.out.println("Pós-ordem: " + bst.postorder());

        // Remover todos
        System.out.println("\n--- Removendo todos os elementos ---");
        while (!bst.isEmpty()) {
            int min = bst.min();
            System.out.println("Removendo " + min);
            bst.remove(min);
            bst.show();
        }
        System.out.println("Árvore vazia? " + bst.isEmpty());
    }
}