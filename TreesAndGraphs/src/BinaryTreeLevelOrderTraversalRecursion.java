import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalRecursion {
    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level){
        // start the current level
        if (levels.size() == level){
            levels.add(new ArrayList<>());
        }

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    /*
    Time complexity :O(N) since each node is processed exactly once.
    Space complexity :O(N) to keep the output structure
    which contains N node values.
     */
}
