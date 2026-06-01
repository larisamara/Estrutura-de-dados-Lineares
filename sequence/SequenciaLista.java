package sequence;

import list.ListaEncadeada;
import list.NoDuplo;

/**
 * Implementação de Sequência usando Lista Duplamente Encadeada.
 * Herda de ListaEncadeada para evitar repetição de código.
 */
public class SequenciaLista extends ListaEncadeada implements ISequencia {

    // --- Implementação dos métodos de IVetor via Rank ---

    @Override
    public Object elementoNoIndice(int indice) {
        return noNoIndice(indice).getElemento();
    }

    @Override
    public Object substituiNoIndice(int indice, Object elemento) {
        return substitui(noNoIndice(indice), elemento);
    }

    @Override
    public void insereNoIndice(int indice, Object elemento) {
        if (indice == tamanho()) {
            insereUltimo(elemento);
        } else {
            insereAntes(noNoIndice(indice), elemento);
        }
    }

    @Override
    public Object removeNoIndice(int indice) {
        return remove(noNoIndice(indice));
    }

    @Override
    public boolean estaVazio() {
        return super.estaVazia();
    }

    @Override
    public int tamanho() {
        return super.tamanho();
    }

    // --- Métodos de Ponte (ISequencia) ---

    @Override
    public NoDuplo noNoIndice(int indice) {
        if (indice < 0 || indice >= tamanho()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        
        NoDuplo atual;
        // Otimização: decide se começa a busca pelo início ou pelo fim
        if (indice < tamanho() / 2) {
            atual = primeiro();
            for (int i = 0; i < indice; i++) atual = atual.getProximo();
        } else {
            atual = ultimo();
            for (int i = tamanho() - 1; i > indice; i--) atual = atual.getAnterior();
        }
        return atual;
    }

    @Override
    public int indiceDe(NoDuplo no) {
        NoDuplo atual = primeiro();
        int indice = 0;
        while (atual != null) {
            if (atual == no) return indice;
            atual = proximo(atual);
            indice++;
        }
        throw new IllegalArgumentException("Nó não pertence à sequência");
    }
}
