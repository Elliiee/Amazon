/*
Validate Binary Search Tree
Recursion
 */
public class ValidateBinarySearchTreeRecursion {
    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null)   return true;

        int val = node.val;

        if (lower != null && val <= lower)  return false;
        if (upper != null && val >= upper)  return false;

        if (! helper(node.right, val, upper))   return false;
        if (! helper(node.left, lower, val))    return false;

        return true;
    }

    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    /*
    Use limits lower and upper, because all the right/left subtree values should be bigger/less than the parent's.
     */

    // time complexity O(N) since we visit each node exactly once
    // space complexity O(N) since we keep up to the entire tree
}
