package list;

public class List {
  private NodeDoubly start, end;
	int quantity;

	public List() {
		quantity = 0;
		
		start = new NodeDoubly();
		end = new NodeDoubly();
		start.setNext(end);
	}

	public int size() {
		return quantity;
	}

	public boolean isEmpty() {
		return quantity == 0;
	}

public boolean isFirst(NodeDoubly n) {
		return n.getPrev() == start;
	}

	public boolean isLast(NodeDoubly n) {
		return n.getNext() == end;
	}

	public NodeDoubly first() {
		return start.getNext();
	}

	public NodeDoubly last() {
		return end.getPrev();
	}

	public NodeDoubly before(NodeDoubly n) {
		return n.getPrev();
	}

	public NodeDoubly after(NodeDoubly n) {
		return n.getNext();
	}

	public Object replaceElement(NodeDoubly n, Object element) {
		Object oldElement = n.getElement();
		n.setElement(element);
		return oldElement;
	}

	public void swapElements(NodeDoubly n, NodeDoubly q) {
		Object temp = n.getElement();
		n.setElement(q.getElement());
		q.setElement(temp);
	}

	public NodeDoubly insertBefore(NodeDoubly node, Object element) {    
    quantity++;
    NodeDoubly newNode = new NodeDoubly();
		newNode.setElement(element);
		newNode.setNext(node);
		newNode.setPrev(node.getPrev());
		node.setPrev(newNode);
    return newNode;
  }

	public NodeDoubly insertAfter(NodeDoubly node, Object element) {    
    quantity++;
    NodeDoubly newNode = new NodeDoubly();
		newNode.setElement(element);
		newNode.setPrev(node);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
    return newNode;
  }

	public NodeDoubly insertFirst(Object element) {
		quantity++;
		NodeDoubly newNode = new NodeDoubly();
		newNode.setElement(element);
		newNode.setPrev(start);
		newNode.setNext(start.getNext());
		start.getNext().setPrev(newNode);
		start.setNext(newNode);
		return newNode;
	}

	public NodeDoubly insertLast(Object element) {
		quantity++;
		//passo 1º a sofia -> end OBS precisa apontar para maykon no 3º passo
		NodeDoubly prevOfEnd = end.getPrev();
		//passo 2º sofia <- maykon -> end
		NodeDoubly node  = this. createChildMaykon(end, prevOfEnd, element);
		//passo 3º sofia -> maykon		
		prevOfEnd.setNext(node);
		//passo 4º end -> maykon
		end.setPrev(node);
		// devolve maykon para a mãe lala lista
		return node;
	}

	public Object remove(NodeDoubly node){
		NodeDoubly temp = node;
		NodeDoubly prevNode = node.getPrev();
		NodeDoubly nextNode = node.getNext();

		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);

		node.setPrev(null);
		node.setNext(null);
		return temp;
	}

	public NodeDoubly createChildMaykon(NodeDoubly next, NodeDoubly prev, Object element) {
		NodeDoubly maykon = new NodeDoubly();
		maykon.setElement(element);
		maykon.setNext(next);
		maykon.setPrev(prev);
		return maykon;
	}

}