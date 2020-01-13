import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree,
return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    //Here the problem is to implement split-level BFS traversal.

    /*
    Approach 1: recursion
     */
    List<List<Integer>> levels = new ArrayList<>();
    public void helper(TreeNode node, int level){
        // start the current level
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }

        // fulfill the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null){
            helper(node.left, level+1);
        }
        if (node.right != null){
            helper(node.right, level+1);
        }
    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root){
        if (root == null){
            return levels;
        }
        helper(root, 0);
        return levels;
    }
    /*
    Time complexity O(N) since each node is processed exactly once.
    Space complexity O(N) to keep the output structure which contains N nodes values.
     */

    /*
    Approach 2: Iteration
     */
    public List<List<Integer>> levelOrderIteration(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null){
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            // start at the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();

            for (int i = 0; i < level_length; i++){
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child node of the current level
                // in the queue for the next level
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
    }
    /*
    Time complexity O(N) since each node is processed exactly once
    Space complexity O(N) to keep the output structure which contains N node values
     */
}
