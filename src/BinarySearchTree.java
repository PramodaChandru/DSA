import com.sun.source.tree.Tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode root;

    private class TreeNode {
        private T data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T val) {
        if(isEmpty()) {
            root = new TreeNode(val);
        } else {
            insert(root, val);
        }
    }

    private void insert(TreeNode node, T val) {

        if(val.compareTo(node.data) < 0) {
            if(node.left == null)
                node.left = new TreeNode(val);
            else
                insert(node.left, val);
        }
        else {
            if(node.right == null)
                node.right = new TreeNode(val);
            else
                insert(node.right, val);
        }
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public TreeNode search(T key) {
        return search(root, key);
    }

    public TreeNode search(TreeNode root, T key) {
        if(root == null || root.data == key) {
            return root;
        }

        if(key.compareTo(root.data) < 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree();

        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        bst.insert(5);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        System.out.print("Preorder Recursive --> ");
        bst.preOrder(bst.root);

        System.out.println("\n"+bst.search(7));
    }
}
