public class DiameterOfBinaryTree {

    static int diameter = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Diameter passing through current node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter: " + diameterOfBinaryTree(root));
    }
}