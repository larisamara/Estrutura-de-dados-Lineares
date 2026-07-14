import java.util.*;

class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data     = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public boolean removeChild(TreeNode<T> child) {
        return children.remove(child);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

class GenericTree<T> {
    private TreeNode<T> root;

    public GenericTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreeNode<T> search(T data) {
        return searchRecursive(root, data);
    }

    private TreeNode<T> searchRecursive(TreeNode<T> node, T data) {
        if (node == null) return null;
        if (node.getData().equals(data)) return node;

        for (TreeNode<T> child : node.getChildren()) {
            TreeNode<T> found = searchRecursive(child, data);
            if (found != null) return found;
        }
        return null;
    }

    public boolean insert(T parentData, T childData) {
        if (root == null) {
            root = new TreeNode<>(childData);
            return true;
        }

        TreeNode<T> parent = search(parentData);
        if (parent == null) {
            return false; 
        }

        TreeNode<T> child = new TreeNode<>(childData);
        parent.addChild(child);
        return true;
    }

    public boolean remove(T data) {
        if (root == null) return false;

        if (root.getData().equals(data)) {
            root = null;
            return true;
        }

        return removeRecursive(root, data);
    }

    private boolean removeRecursive(TreeNode<T> node, T data) {
        Iterator<TreeNode<T>> it = node.getChildren().iterator();
        while (it.hasNext()) {
            TreeNode<T> child = it.next();

            if (child.getData().equals(data)) {
                it.remove();
                return true;
            }

            if (removeRecursive(child, data)) {
                return true;
            }
        }
        return false;
    }

    public List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private void preOrderRecursive(TreeNode<T> node, List<T> result) {
        if (node == null) return;

        result.add(node.getData());
        for (TreeNode<T> child : node.getChildren()) {
            preOrderRecursive(child, result);
        }
    }

    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private void postOrderRecursive(TreeNode<T> node, List<T> result) {
        if (node == null) return;

        for (TreeNode<T> child : node.getChildren()) {
            postOrderRecursive(child, result);
        }
        result.add(node.getData());
    }

    public List<T> breadthFirst() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            result.add(current.getData());
            queue.addAll(current.getChildren());
        }
        return result;
    }

    public void print() {
        printRecursive(root, 0);
    }

    private void printRecursive(TreeNode<T> node, int level) {
        if (node == null) {
            System.out.println("Árvore vazia");
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getData());

        for (TreeNode<T> child : node.getChildren()) {
            printRecursive(child, level + 1);
        }
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(TreeNode<T> node) {
        if (node == null) return 0;

        int count = 1;
        for (TreeNode<T> child : node.getChildren()) {
            count += sizeRecursive(child);
        }
        return count;
    }
}

