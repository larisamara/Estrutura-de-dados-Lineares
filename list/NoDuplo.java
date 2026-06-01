package list;

/**
 * Representa um nó em uma estrutura duplamente encadeada.
 * Armazena o elemento e referências para o próximo e o anterior.
 */
public class NoDuplo {
    private Object elemento;
    private NoDuplo proximo, anterior;

    public NoDuplo(Object elemento, NoDuplo anterior, NoDuplo proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public NoDuplo() {
        this(null, null, null);
    }

    public Object getElemento() { return elemento; }
    public void setElemento(Object elemento) { this.elemento = elemento; }

    public NoDuplo getProximo() { return proximo; }
    public void setProximo(NoDuplo proximo) { this.proximo = proximo; }

    public NoDuplo getAnterior() { return anterior; }
    public void setAnterior(NoDuplo anterior) { this.anterior = anterior; }
}
