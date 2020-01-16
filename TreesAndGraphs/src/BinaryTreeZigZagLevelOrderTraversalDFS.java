import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversalDFS {
    public void DFS(TreeNode node, int level, List<List<Integer>> results){
        if (level >= results.size()){
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(node.val);
            results.add(newLevel);
        }
        else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null)
            DFS(node.left, level + 1, results);
        if (node.right != null)
            DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) return results;

        DFS(root, 0, results);
        return results;
    }
}
