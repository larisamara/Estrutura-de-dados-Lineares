package vector;

/**
 * Implementação de Vetor usando Array (Arranjo).
 * Ideal para acesso rápido via índice.
 */
public class VetorArranjo implements IVetor {
    private Object[] dados;
    private int capacidade;
    private int quantidade;

    public VetorArranjo(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.dados = new Object[capacidade];
        this.quantidade = 0;
    }

    public VetorArranjo() {
        this(10);
    }

    @Override
    public Object elementoNoIndice(int indice) {
        if (indice < 0 || indice >= quantidade) throw new IndexOutOfBoundsException("Índice inválido");
        return dados[indice];
    }

    @Override
    public Object substituiNoIndice(int indice, Object elemento) {
        if (indice < 0 || indice >= quantidade) throw new IndexOutOfBoundsException("Índice inválido");
        Object antigo = dados[indice];
        dados[indice] = elemento;
        return antigo;
    }

    @Override
    public void insereNoIndice(int indice, Object elemento) {
        if (indice < 0 || indice > quantidade) throw new IndexOutOfBoundsException("Índice inválido");
        
        // Se o array estiver cheio, dobramos o tamanho
        if (quantidade == capacidade) {
            capacidade *= 2;
            Object[] novoArranjo = new Object[capacidade];
            for (int i = 0; i < quantidade; i++) {
                novoArranjo[i] = dados[i];
            }
            dados = novoArranjo;
        }

        // Abre espaço deslocando os elementos para a direita
        for (int i = quantidade - 1; i >= indice; i--) {
            dados[i + 1] = dados[i];
        }
        
        dados[indice] = elemento;
        quantidade++;
    }

    @Override
    public Object removeNoIndice(int indice) {
        if (indice < 0 || indice >= quantidade) throw new IndexOutOfBoundsException("Índice inválido");
        Object removido = dados[indice];
        
        // Fecha o buraco deslocando os elementos para a esquerda
        for (int i = indice; i < quantidade - 1; i++) {
            dados[i] = dados[i + 1];
        }
        
        dados[quantidade - 1] = null; // Ajuda o Garbage Collector
        quantidade--;
        return removido;
    }

    @Override
    public boolean estaVazio() { return quantidade == 0; }

    @Override
    public int tamanho() { return quantidade; }
}
