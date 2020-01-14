/*
Diameter of Binary Tree
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {
    /*
    DFS

     */
    int ans;
    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root){
        ans = 1;
        depth(root);
        return ans - 1;
    }
}
