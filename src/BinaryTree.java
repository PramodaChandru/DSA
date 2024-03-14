import com.sun.source.tree.Tree;

import java.net.Inet4Address;

public class BinaryTree<T extends Comparable<T>> {
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



    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderItr(TreeNode root) {
        if(root == null) {
            return;
        }
        StackA<TreeNode> stack = new StackA<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public void inOrderItr(TreeNode root) {
        if(root == null) {
            return;
        }
        StackA<TreeNode> stack = new StackA<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void createBT(T[] arr) {
        root = new TreeNode(arr[0]);
       TreeNode second = new TreeNode(arr[1]);
        TreeNode third = new TreeNode(arr[2]);
        TreeNode fourth = new TreeNode(arr[3]);
        TreeNode fifth = new TreeNode(arr[4]);
//        TreeNode sixth = new TreeNode(arr[5]);
//        TreeNode seventh = new TreeNode(arr[6]);
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public int findMax() {
        return findMax(root);
    }

    public int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int result = (Integer) root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(left > result) {
            result = left;
        }

        if(right > result) {
            result = right;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.createBT(new Integer[]{1,2,3,4,5,6});
        System.out.print("Preorder Recursive --> ");
        bt.preOrder(bt.root);
        System.out.print("\nPreorder Iterative --> ");
        bt.preOrderItr(bt.root);
        System.out.print("\nInOrder Recursive --> ");
        bt.inOrder(bt.root);
        System.out.print("\nInOrder Iterative --> ");
        bt.inOrderItr(bt.root);
        System.out.print("\nPostOrder Recursive --> ");
        bt.postOrder(bt.root);
        System.out.println();
        bt.createBT(new Integer[]{4,3,7,5,8,7});
        bt.preOrder(bt.root);

        System.out.println("\n"+bt.findMax());
    }
}
