package vector;

/**
 * Interface para um Vetor (Rank-based).
 * Foca no acesso por índice (rank).
 */
public interface IVetor {
    public Object elementoNoIndice(int indice);
    public Object substituiNoIndice(int indice, Object elemento);
    public void insereNoIndice(int indice, Object elemento);
    public Object removeNoIndice(int indice);
    public boolean estaVazio();
    public int tamanho();
}
