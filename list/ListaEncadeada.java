package list;

/**
 * Implementação de Lista Posicional usando Lista Duplamente Encadeada.
 * Utiliza nós sentinelas (inicio e fim) para simplificar as operações.
 */
public class ListaEncadeada implements ILista {
    private NoDuplo inicio, fim;
    private int quantidade;

    public ListaEncadeada() {
        quantidade = 0;
        inicio = new NoDuplo(); // Sentinela de início
        fim = new NoDuplo();    // Sentinela de fim
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }

    @Override
    public int tamanho() { return quantidade; }

    @Override
    public boolean estaVazia() { return quantidade == 0; }

    @Override
    public NoDuplo primeiro() {
        if (estaVazia()) return null;
        return inicio.getProximo();
    }

    @Override
    public NoDuplo ultimo() {
        if (estaVazia()) return null;
        return fim.getAnterior();
    }

    @Override
    public NoDuplo proximo(NoDuplo n) {
        NoDuplo prox = n.getProximo();
        return (prox == fim) ? null : prox;
    }

    @Override
    public NoDuplo anterior(NoDuplo n) {
        NoDuplo ant = n.getAnterior();
        return (ant == inicio) ? null : ant;
    }

    @Override
    public NoDuplo insereAntes(NoDuplo n, Object o) {
        NoDuplo ant = n.getAnterior();
        NoDuplo novo = new NoDuplo(o, ant, n);
        ant.setProximo(novo);
        n.setAnterior(novo);
        quantidade++;
        return novo;
    }

    @Override
    public NoDuplo insereDepois(NoDuplo n, Object o) {
        NoDuplo prox = n.getProximo();
        NoDuplo novo = new NoDuplo(o, n, prox);
        prox.setAnterior(novo);
        n.setProximo(novo);
        quantidade++;
        return novo;
    }

    @Override
    public NoDuplo inserePrimeiro(Object o) {
        return insereDepois(inicio, o);
    }

    @Override
    public NoDuplo insereUltimo(Object o) {
        return insereAntes(fim, o);
    }

    @Override
    public Object remove(NoDuplo n) {
        NoDuplo ant = n.getAnterior();
        NoDuplo prox = n.getProximo();
        
        ant.setProximo(prox);
        prox.setAnterior(ant);
        
        Object temp = n.getElemento();
        n.setProximo(null); // Ajuda o GC
        n.setAnterior(null);
        quantidade--;
        return temp;
    }

    @Override
    public Object substitui(NoDuplo n, Object o) {
        Object antigo = n.getElemento();
        n.setElemento(o);
        return antigo;
    }

    @Override
    public void troca(NoDuplo n, NoDuplo q) {
        Object temp = n.getElemento();
        n.setElemento(q.getElemento());
        q.setElemento(temp);
    }
}
