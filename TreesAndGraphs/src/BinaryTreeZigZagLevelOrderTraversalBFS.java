import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversalBFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) return results;

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0){
            TreeNode curr_node = node_queue.pollFirst();

            if (curr_node != null){
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            }
            else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<>();

                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null); // delimiter marks as the new level starts
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
