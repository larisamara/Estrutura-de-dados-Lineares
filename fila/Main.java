/*
 * Questão 03 (original) - TADs Fila e Pilha utilizando a estrutura de dados concreta lista simplesmente encadeada.
 * Questão 07 (alterada) - IMPLEMENTE EM JAVA/C# o TAD Fila, utilizando duas pilhas
 * Questão 08 (alterada) - IMPLEMENTE EM JAVA/C# o TAD Pilha, utilizando duas filas
 * Nova Questão -  IMPLEMENTE EM JAVA/C# o TAD Pilha utilizando uma Lista Simplesmente Encadeada.
 */
class Main {

  public static void main(String[] args) {
    IFilaSimpEncad fila = new FilaSimpEncad();
    fila.enfileirar("Larissa");
    fila.mostrar();
    fila.enfileirar("Samara");
    fila.mostrar();
    fila.enfileirar("Xavier");
    fila.mostrar();
    fila.desenfileirar();
    fila.mostrar();
  }
}
