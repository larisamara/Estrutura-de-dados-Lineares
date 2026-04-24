public class Main {
  public static void main(String[] args) {
    // Inicia com capacidade 6 para testar redimensionamento rápido
    StackRedBlack srb = new StackRedBlack(6);

    System.out.println("--- Inserindo elementos ---");
    srb.empilharVermelho("Vermelho 1");
    srb.empilharVermelho("Vermelho 2");
    srb.empilharVermelho("Vermelho 3");
    
    srb.empilharPreto("Preto 1");
    srb.empilharPreto("Preto 2");
    srb.empilharPreto("Preto 3");

    // O vetor está com 6/6 ocupado. A próxima inserção deve duplicar (12).
    System.out.println("\n--- Testando Expansão (deve duplicar capacidade) ---");
    srb.empilharVermelho("Vermelho 4");

    System.out.println("\n--- Desempilhando elementos ---");
    System.out.println("Desempilhou: " + srb.desempilharVermelho()); // Vermelho 4
    System.out.println("Desempilhou: " + srb.desempilharPreto());    // Preto 3
    System.out.println("Desempilhou: " + srb.desempilharPreto());    // Preto 2
    
    // Agora temos: [V1, V2, V3] e [P1]. Total 4 elementos.
    // Capacidade atual é 12. 4 <= 12/3 (4 <= 4). 
    // O próximo pop que atingir ou passar dessa marca deve reduzir a capacidade para 6.
    System.out.println("\n--- Testando Redução (deve reduzir capacidade) ---");
    System.out.println("Desempilhou: " + srb.desempilharVermelho()); // Vermelho 3
    
    System.out.println("\n--- Estado Final ---");
    System.out.println("Resto Vermelho: " + srb.desempilharVermelho()); // Vermelho 2
    System.out.println("Resto Vermelho: " + srb.desempilharVermelho()); // Vermelho 1
    System.out.println("Vazio Vermelho: " + srb.desempilharVermelho()); // Mensagem de vazio
    System.out.println("Resto Preto:    " + srb.desempilharPreto());    // Preto 1
    System.out.println("Vazio Preto:    " + srb.desempilharPreto());    // Mensagem de vazio
  }
}
