import java.util.ArrayList;

public class BinaryTreeNode {
	private Object element;
	private int key;
	private ArrayList<BinaryTreeNode> children = new ArrayList<BinaryTreeNode>();
	private BinaryTreeNode dad;
	public BinaryTreeNode left, right;
	
	public BinaryTreeNode(Object element, BinaryTreeNode dad) {
		this.dad = dad;
		this.element = element;
	}
	public BinaryTreeNode(int key){		
		this.key = key;
		left = right = null;
	}
	public Object getElement() {
		return element;
	}
	public int getKey(){
		return key;
	}
	public void setPai(BinaryTreeNode dad){
		this.dad = dad;
	}
	public BinaryTreeNode getLeftChild(BinaryTreeNode child){
		return child.left;
	}
	public BinaryTreeNode getRightChild(BinaryTreeNode child){
		return child.right;
	}

	public BinaryTreeNode getDad() {
		return dad;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	public void addChild(BinaryTreeNode child) {
			children.add(child);
	}

	public void removeChild(BinaryTreeNode child) {
		children.remove(child);
	}

	public int childrenSize() {
		return children.size();
	}

	public ArrayList<BinaryTreeNode> getChildren() {			
		return children;
	}
}