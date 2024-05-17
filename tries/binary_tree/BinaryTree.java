import static java.lang.Integer.max;

import java.lang.Thread;
import java.util.ArrayList;

public class BinaryTree {

  public BinaryTreeNode root, dad;
  int size = 0;
  ArrayList<BinaryTreeNode> nodeList = new ArrayList<BinaryTreeNode>();
  ArrayList<BinaryTreeNode> nodesListHeight = new ArrayList<BinaryTreeNode>();
  ArrayList<BinaryTreeNode> nodeListElements = new ArrayList<BinaryTreeNode>();

  public BinaryTreeNode search(BinaryTreeNode node, int key) {
    if (node == null || node.getKey() == key) {
      return node;
    }
    if (node.getKey() > key) {
      return search(node.left, key);
    }
    return search(node.right, key);
  }

  public ArrayList<BinaryTreeNode> children(BinaryTreeNode node) {
    ArrayList<BinaryTreeNode> tree = new ArrayList<BinaryTreeNode>();
    if (node.left != null) tree.add(node.left);
    if (node.right != null) tree.add(node.right);
    return tree;
  }

  public int size() {
    return size;
  }

  public BinaryTreeNode inserirNode(int key) {
    root = insert(root, key);
    size++;
    return root;
  }

  public BinaryTreeNode insert(BinaryTreeNode node, int key) {
    if (node == null) {
      node = new BinaryTreeNode(key);
      size++;
    } else if (key < node.getKey()) {
      node.left = insert(node.left, key);
    } else {
      node.right = insert(node.right, key);
    }
    return node;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public boolean isRoot(BinaryTreeNode node) {
    return node == root;
  }

  public int getHeight(BinaryTreeNode node) {
    if (isExternal(node)) return 0; else {
      int heightTree = 0;
      for (BinaryTreeNode child : children(node)) {
        heightTree = max(heightTree, getHeight(child));
      }
      return ++heightTree;
    }
  }

  public boolean isExternal(BinaryTreeNode node) {
    if (node.left == null && node.right == null) {
      return true;
    }
    return false;
  }

  public BinaryTreeNode getRoot() {
    return root;
  }

  public ArrayList<BinaryTreeNode> getElements() {
    nodeList.clear();
    preOrderElements(getRoot());
    return nodeList;
  }

  public void preOrderElements(BinaryTreeNode node) {
    nodeList.add(node);
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (isInternal(left)) preOrderElements(left);
    if (isInternal(right)) preOrderElements(right);
  }

  public boolean isInternal(BinaryTreeNode node) {
    if (node != null) {
      return true;
    }
    return false;
  }

  private void conductVisit(String method, BinaryTreeNode node) {
    System.out.println(method + ": " + node.getKey());
  }

  public void preOrder(BinaryTreeNode node) {
    this.conductVisit("preOrder", node);
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (isInternal(left)) preOrder(left);
    if (isInternal(right)) preOrder(right);
  }

  public void posOrder(BinaryTreeNode node) {
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (left != null) posOrder(left);
    if (right != null) posOrder(right);
    this.conductVisit("posOrder", node);
  }

  public void inOrder(BinaryTreeNode node) {
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (left != null) inOrder(left);
    this.conductVisit("inOrder", node);
    if (right != null) inOrder(right);
  }

  public int getDepth(BinaryTreeNode node) {
    int height = 0;
    if (node == root) {
      System.out.println(height);
      return 0;
    } else {
      height++;
      System.out.println(height);
      return 1 + getDepth(getParent(node));
    }
  }

  public BinaryTreeNode getParent(BinaryTreeNode node) {
    BinaryTreeNode dad = root;
    if (node != null) {
      if (node == root) {
        return getRoot();
      }
      if (dad.left == node) {
        return dad;
      } else if (dad.right != node) {
        dad = getParent(dad.right);
      }
    }
    return dad;
  }

  

  public void printBinaryTree() throws InterruptedException {
    printTreeInOrder(root);
    int height = getHeight(root);

    System.out.println("Altura: " + height);
    System.out.println("quantidade de nós: " + nodeListElements.size());
    int quantityNodes = nodeListElements.size();
    int matrix[][] = new int[height][quantityNodes];
    for (int i = 0; i < nodeListElements.size(); i++) {
      int num = (Integer) nodeListElements.get(i).getKey();
      matrix[getDepth((BinaryTreeNode) nodeListElements.get(i))][i] = num;
    }
    System.out.println();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < quantityNodes; j++) {
        if (matrix[i][j] == 0) {
          System.out.print("\t");
        } else {
          System.out.print("\t" + matrix[i][j]);
          Thread.sleep(1000);
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public void printTreeInOrder(BinaryTreeNode node) {
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (left != null) printTreeInOrder(left);
    this.visitorPrintTree(node);
    if (right != null) printTreeInOrder(right);
  }

  private void visitorPrintTree(BinaryTreeNode node) {
    System.out.println(
      "Node Key: " + node.getKey() + " profundidade: " + getDepth(node)
    );
    nodeListElements.add(node);
  }

  public void printByRoot() {
    printNodeIndent(root, "");
  }

  private void printNodeIndent(BinaryTreeNode node, String indent) {
    if (node != null) {
      printNodeIndent(node.left, indent + "----");
      System.out.println("\n" + indent + node.getKey());
      printNodeIndent(node.right, indent + "----");
    }
  }

  public void preOrderNos(BinaryTreeNode node) {
    System.out.println(node);
    System.out.println(node.getKey());
    nodeList.add(node);
    BinaryTreeNode left = node.getLeftChild(node);
    BinaryTreeNode right = node.getRightChild(node);
    if (isInternal(left)) preOrderNos(left);
    if (isInternal(right)) preOrderNos(right);
  }

  public ArrayList<BinaryTreeNode> nos() {
    nodeList.clear();
    preOrderNos(getRoot());
    return nodeList;
  }
}
