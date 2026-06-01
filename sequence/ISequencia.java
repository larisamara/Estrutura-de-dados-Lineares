package sequence;

import list.ILista;
import list.NoDuplo;
import vector.IVetor;

/**
 * Interface para uma Sequência.
 * Combina as funcionalidades de Lista (Posicional) e Vetor (Índices).
 */
public interface ISequencia extends ILista, IVetor {
    // Retorna a posição (nó) associada ao índice informado
    public NoDuplo noNoIndice(int indice);
    
    // Retorna o índice associado à posição (nó) informada
    public int indiceDe(NoDuplo no);
}
