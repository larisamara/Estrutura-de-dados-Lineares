public class Vector implements IVector {
	private Object[] vector;
	private int size;
	private int quantity = 1;

	public Vector(int size) {
		this.size = size;
		vector = new Object[size];
	}

	public Object elementAtRank(int rank) {
		return vector[rank];
	}

	public Object replaceAtRank(int rank, Object element) {
		Object temp = vector[rank];
		vector[rank] = element;
		return temp;
	}

	public void insertAtRank(int rank, Object element) {
		if (quantity == size) {
			size *= 2;
			Object[] newVector = new Object[size];
			for (int i = 0; i < quantity; i++) {
				newVector[i] = vector[i];
			}
			vector = newVector;
		} else {
			/* ele percorre do final até a posição que quero inserir movendo os elementos */
			for (int i = quantity - 1; i >= rank; i--) {
				vector[i + 1] = vector[i];
			}
			vector[quantity] = element;
			quantity++;
		}
	}

	public Object removeAtRank(int rank) {
		if (!(rank >= 0 && rank < size)) {
			System.out.println("Posição não existe");
		}
		Object temp = vector[rank];
		for (int i = rank; i < size - 1; i++) {
			// removendo e realocando os elementos voltando 1.
			vector[i] = vector[i + 1];
		}
		quantity--;
		return temp;
	}

	public boolean isEmpty() {
		return sizeInsert() == 0;
	}

	public int sizeInsert() {
		return quantity;
	}

}