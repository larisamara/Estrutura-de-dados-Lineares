// ========================================================================
// CLASSE DE TESTES
// ========================================================================

class TestHashTable {
    public static void main(String[] args) {
        System.out.println("===== TESTE COM LINEAR PROBING =====");
        HashTable<String, Integer> linearTable = new HashTable<>(8, ProbingType.LINEAR);
        testTable(linearTable);

        System.out.println("===== TESTE COM HASH DUPLO =====");
        HashTable<String, Integer> doubleTable = new HashTable<>(8, ProbingType.DOUBLE_HASH);
        testTable(doubleTable);
    }

    private static void testTable(HashTable<String, Integer> table) {
        // Inserções
        System.out.println("\n--- Inserindo: João=25, Maria=30, José=22, Ana=28 ---");
        table.insert("João", 25);
        table.insert("Maria", 30);
        table.insert("José", 22);
        table.insert("Ana", 28);
        table.printTable();

        System.out.println("--- Inserindo Pedro=35 (pode causar rehash) ---");
        table.insert("Pedro", 35);
        table.printTable();

        // Buscas
        System.out.println("Buscar 'João': " + table.search("João")); // 25
        System.out.println("Buscar 'Carlos': " + table.search("Carlos")); // null

        // Remoção
        System.out.println("\nRemover 'Maria': " + table.remove("Maria"));
        table.printTable();

        System.out.println("Remover 'José': " + table.remove("José"));
        table.printTable();

        // Tentar buscar removido
        System.out.println("Buscar 'Maria' após remoção: " + table.search("Maria"));

        // Inserir novamente para testar reutilização de slots deletados
        System.out.println("\nInserir 'Carlos'=40");
        table.insert("Carlos", 40);
        table.printTable();

        // Forçar rehash com mais inserções
        System.out.println("\nInserindo mais elementos para forçar rehash...");
        table.insert("Fernanda", 45);
        table.insert("Lucas", 50);
        table.insert("Mariana", 55);
        table.printTable();

        // Limpeza
        System.out.println("Limpar tabela...");
        table.clear();
        System.out.println("Tamanho após clear: " + table.size());
        System.out.println("Vazia? " + table.isEmpty());
        table.printTable();
    }
}