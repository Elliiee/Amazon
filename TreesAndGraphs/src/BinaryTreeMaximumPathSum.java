/*
Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.
The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    /*
    Recursion

     */
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node){
        if (node == null){
            return 0;
        }

        // max sum on the left and right sub-trees of a node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where this node is the highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion: return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }

    /*
    Time complexity: O(N)
    Space complexity O(logN). we have to keep a recursion stack of the size of the tree height
     */
}