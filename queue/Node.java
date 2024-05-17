public class Node {
  private Object element;
	private Node next;

	public void setElement(Object o) {
		element = o;
	}

	public Object getElement() {
		return element;

	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}
}
