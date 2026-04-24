public class StackRedBlack {
  private Object[] vetor;
  private int topoVermelho, topoPreto, capacidade;

  public StackRedBlack(int capacidade) {
    this.capacidade = capacidade;
    this.vetor = new Object[capacidade];
    this.topoVermelho = -1;
    this.topoPreto = capacidade;
  }

  public void empilharVermelho(Object o) {
    if (topoVermelho + 1 == topoPreto) redimensionar(capacidade * 2);
    vetor[++topoVermelho] = o;
  }

  public void empilharPreto(Object o) {
    if (topoVermelho + 1 == topoPreto) redimensionar(capacidade * 2);
    vetor[--topoPreto] = o;
  }

  public Object desempilharVermelho() {
    if (topoVermelho == -1) return "Pilha Vermelha Vazia";
    Object o = vetor[topoVermelho];
    vetor[topoVermelho--] = null;
    verificarReducao();
    return o;
  }

  public Object desempilharPreto() {
    if (topoPreto == capacidade) return "Pilha Preta Vazia";
    Object o = vetor[topoPreto];
    vetor[topoPreto++] = null;
    verificarReducao();
    return o;
  }

  private void verificarReducao() {
    int ocupado = (topoVermelho + 1) + (capacidade - topoPreto);
    if (capacidade > 4 && ocupado <= capacidade / 3) { 
      redimensionar(capacidade / 2);
    }
  }

  private void redimensionar(int novaCapacidade) {
    Object[] novoVetor = new Object[novaCapacidade];
    // Copia pilha vermelha
    System.arraycopy(vetor, 0, novoVetor, 0, topoVermelho + 1);
    
    // Copia pilha preta para o novo final
    int tamanhoPreto = capacidade - topoPreto;
    int novoTopoPreto = novaCapacidade - tamanhoPreto;
    System.arraycopy(vetor, topoPreto, novoVetor, novoTopoPreto, tamanhoPreto);
    
    this.vetor = novoVetor;
    this.topoPreto = novoTopoPreto;
    this.capacidade = novaCapacidade;
  }
}
