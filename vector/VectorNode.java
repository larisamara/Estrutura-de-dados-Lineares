public class VectorNode implements IVector {
	private NodeDoubly head ;
	private int quantity = 0;

	public Object elementAtRank(int rank) {
		NodeDoubly target;
		target = this.getTarget(rank, head);
		return target.getElement();
	}

	public Object replaceAtRank(int rank, Object element) {
		NodeDoubly target;
		target = this.getTarget(rank, head);
		NodeDoubly node = new NodeDoubly();
		node.setNext(target.getNext());
		node.setPrev(target.getPrev());
		node.setElement(element);

		return target.getElement();

	}

	public void insertAtRank(int rank, Object element) {
		NodeDoubly node = new NodeDoubly();
		node.setElement(element);

		if(head == null)  head = node;
		
		NodeDoubly target;
		target = this.getTarget(rank, head);
		
		NodeDoubly nodeNextTarget = target.getNext();
		// target -> node
		target.setNext(node);
		//  proximo de target -> node
		nodeNextTarget.setPrev(node);
		// node -> proximo de target
		node.setNext(nodeNextTarget);
		// node -> target
		node.setPrev(target);
		quantity++;

	}

	public Object removeAtRank(int rank) {
		NodeDoubly target;
		target = this.getTarget(rank, head);
		NodeDoubly prev = target.getPrev();
		NodeDoubly next = target.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		quantity--;
		return target;
	}

	public boolean isEmpty() {
		return sizeInsert() == 0;
	}

	public int sizeInsert() {
		return quantity;
	}

	private NodeDoubly getTarget(int rank, NodeDoubly target) {
		for (int i = 0; i < rank; i++) {
			target = target.getNext();
		} 
		return target;
	}

}