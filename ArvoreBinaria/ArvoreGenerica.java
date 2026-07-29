import java.util.*;

import java.util.Iterator;

public interface IArvore<E> {

    interface No<E> {
        E getElement();
    }

    int size();
    int height();
    boolean isEmpty();
    Iterator<E> elements();
    Iterator<No<E>> nos();
    No<E> root();
    No<E> parent(No<E> n);
    Iterator<No<E>> children(No<E> n);
    boolean isInternal(No<E> n);
    boolean isExternal(No<E> n);
    boolean isRoot(No<E> n);
    int depth(No<E> n);
    E replace(No<E> n, E o);
}

public class ArvoreGenerica<E> implements IArvore<E> {

    private static class No<E> implements IArvore.No<E> {
        E elemento;
        No<E> pai;
        List<No<E>> filhos = new ArrayList<>();

        No(E elemento) {
            this.elemento = elemento;
        }

        @Override
        public E getElement() {
            return elemento;
        }
    }

    private No<E> raiz;
    private int tamanho = 0;

    public ArvoreGenerica(E elementoRaiz) {
        if (elementoRaiz == null) {
            throw new IllegalArgumentException("Raiz não pode ser nula");
        }
        raiz = new No<>(elementoRaiz);
        tamanho = 1;
    }

    public No<E> addChild(No<E> pai, E elemento) {
        if (pai == null || elemento == null) {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
        No<E> filho = new No<>(elemento);
        filho.pai = pai;
        pai.filhos.add(filho);
        tamanho++;
        return filho;
    }


    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public int height() {
        return height(raiz);
    }

    private int height(No<E> v) {
        if (v.filhos.isEmpty()) {
            return 0;
        }
        int maxAltura = 0;
        for (No<E> filho : v.filhos) {
            int altFilho = height(filho);
            if (altFilho > maxAltura) {
                maxAltura = altFilho;
            }
        }
        return 1 + maxAltura;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public Iterator<E> elements() {
        List<E> lista = new ArrayList<>();
        preOrderElements(raiz, lista);
        return lista.iterator();
    }

    private void preOrderElements(No<E> v, List<E> lista) {
        lista.add(v.elemento);
        for (No<E> filho : v.filhos) {
            preOrderElements(filho, lista);
        }
    }

    @Override
    public Iterator<No<E>> nos() {
        List<No<E>> lista = new ArrayList<>();
        preOrderNos(raiz, lista);
        return lista.iterator();
    }

    private void preOrderNos(No<E> v, List<No<E>> lista) {
        lista.add(v);
        for (No<E> filho : v.filhos) {
            preOrderNos(filho, lista);
        }
    }

    @Override
    public No<E> root() {
        return raiz;
    }

    @Override
    public No<E> parent(No<E> n) {
        if (n == null) return null;
        if (n == raiz) return null;
        return n.pai;
    }

    @Override
    public Iterator<No<E>> children(No<E> n) {
        if (n == null) return Collections.emptyIterator();
        return n.filhos.iterator();
    }

    @Override
    public boolean isInternal(No<E> n) {
        return n != null && !n.filhos.isEmpty();
    }

    @Override
    public boolean isExternal(No<E> n) {
        return n != null && n.filhos.isEmpty();
    }

    @Override
    public boolean isRoot(No<E> n) {
        return n != null && n == raiz;
    }

    @Override
    public int depth(No<E> n) {
        return depthRecursivo(n);
    }

    private int depthRecursivo(No<E> v) {
        if (v == null) return -1;
        if (v == raiz) return 0;
        return 1 + depthRecursivo(v.pai);
    }

    @Override
    public E replace(No<E> n, E o) {
        if (n == null || o == null) {
            throw new IllegalArgumentException("Nó ou novo elemento nulo");
        }
        E antigo = n.elemento;
        n.elemento = o;
        return antigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(raiz, sb, 0);
        return sb.toString();
    }

    private void toStringRec(No<E> v, StringBuilder sb, int nivel) {
        sb.append("  ".repeat(nivel)).append(v.elemento).append("\n");
        for (No<E> filho : v.filhos) {
            toStringRec(filho, sb, nivel + 1);
        }
    }

    public static void main(String[] args) {

        ArvoreGenerica<String> arvore = new ArvoreGenerica<>("A");
        IArvore.No<String> nA = arvore.root();
        IArvore.No<String> nB = arvore.addChild((No<String>) nA, "B");
        IArvore.No<String> nC = arvore.addChild((No<String>) nA, "C");
        IArvore.No<String> nD = arvore.addChild((No<String>) nA, "D");
        arvore.addChild((No<String>) nB, "E");
        arvore.addChild((No<String>) nB, "F");
        arvore.addChild((No<String>) nD, "G");

        System.out.println("Árvore:");
        System.out.println(arvore);

        System.out.println("Tamanho: " + arvore.size());
        System.out.println("Altura: " + arvore.height());
        System.out.println("Profundidade de B: " + arvore.depth((No<String>) nB));
        System.out.println("É folha? C: " + arvore.isExternal(nC) + ", B: " + arvore.isExternal(nB));

        System.out.print("Elementos em Pré-Ordem: ");
        Iterator<String> it = arvore.elements();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Testando replace
        System.out.println("Substituindo C por X: " + arvore.replace((No<String>) nC, "X"));
        System.out.println("Nova raiz? " + arvore.root().getElement());
        System.out.println("Árvore atualizada:");
        System.out.println(arvore);
    }
}