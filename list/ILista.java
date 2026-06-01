package list;

/**
 * Interface para uma Lista Posicional.
 * Foca em posições (nós) em vez de índices numéricos.
 */
public interface ILista {
    public int tamanho();
    public boolean estaVazia();
    
    public NoDuplo primeiro();
    public NoDuplo ultimo();
    
    public NoDuplo proximo(NoDuplo n);
    public NoDuplo anterior(NoDuplo n);
    
    public NoDuplo inserePrimeiro(Object o);
    public NoDuplo insereUltimo(Object o);
    
    public NoDuplo insereAntes(NoDuplo n, Object o);
    public NoDuplo insereDepois(NoDuplo n, Object o);
    
    public Object remove(NoDuplo n);
    public Object substitui(NoDuplo n, Object o);
    public void troca(NoDuplo n, NoDuplo q);
}
