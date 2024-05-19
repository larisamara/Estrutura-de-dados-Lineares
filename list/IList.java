
public interface IList{

  public int size();
  public boolean isEmpty();
  public boolean isFirst(NodeDoubly node);
  public boolean isLast(NodeDoubly node);
  public NodeDoubly first();
  public NodeDoubly last();
  public NodeDoubly before(NodeDoubly node);
  public NodeDoubly after(NodeDoubly node);
  public Object replaceElement(NodeDoubly node, Object element);
  public void swapElements(NodeDoubly nodeOne, NodeDoubly nodeTwo);
  public NodeDoubly insertBefore(NodeDoubly node, Object element);
  public NodeDoubly insertAfter(NodeDoubly node, Object element);
  public NodeDoubly insertFirst(Object element);
  public NodeDoubly insertLast(Object element);
  public Object remove(NodeDoubly node);
}