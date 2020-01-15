import java.util.LinkedList;

/*
Validate Binary Search Tree
Iteration
DFS
 */
public class ValidateBinarySearchTreeIteration {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();

    public void update(TreeNode root, Integer lower, Integer upper){
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST(TreeNode root){
        Integer lower = null, upper = null, val; // note here is using Integer for the linked list
        update(root, lower, upper);

        while (!stack.isEmpty()){
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null)   continue;  // note here is using continue because it's in a loop

            val = root.val;
            if (lower != null && val <= lower)  return false;
            if (upper != null && val >= upper)  return false;

            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    // Time complexity : O(N) since we visit each node exactly once.
    // Space complexity : O(N) since we keep up to the entire tree.
}
