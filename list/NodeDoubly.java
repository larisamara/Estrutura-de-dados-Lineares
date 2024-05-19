public class NodeDoubly {
  private Object element;
	private NodeDoubly next, prev;

	public NodeDoubly getPrev() {
    return prev;
  }

  public void setPrev(NodeDoubly prev) {
    this.prev = prev;
  }

  public void setElement(Object o) {
		element = o;
	}

	public Object getElement() {
		return element;

	}

	public void setNext(NodeDoubly next) {
		this.next = next;
	}

	public NodeDoubly getNext() {
		return this.next;
	}
}
