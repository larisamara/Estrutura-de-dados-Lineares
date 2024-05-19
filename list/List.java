package list;

public class List {
  private NodeDoubly inicio, fim;
	int tam;

	public List() {
		quantity = 0;
		
		inicio = new NodeDoubly(null, null, "inicio");
		fim = new NodeDoubly(inicio, null, "fim");
		inicio.setProximo(fim);
	}

	public int size() {
		return tam;
	}
}

