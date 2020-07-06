(import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    /*
    BFS
    The most intuitive solution would be the BFS.
    The default ordering of BFS is from left to right, so use deque which can add from either end.
    If we want to have FIFO, we simply append the new elements to the tail.
    If we want to have FILO, note: not LIFO, we insert the elements to the head.
     */
    public List<List<Integer>>  zigzagLevelOrderBFS(TreeNode root){
        if (root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<>();

        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null); // add a delimiter to each level

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0){
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null){
                if (is_order_left){
                    level_list.addLast(curr_node.val);
                }
                else {
                    level_list.addFirst(curr_node.val);
                }

                if (curr_node.left != null){
                    node_queue.addLast(curr_node.left);
                }
                if (curr_node.right != null){
                    node_queue.addLast(curr_node.right);
                }
            }
            else{
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();

                // prepare for the next level
                if (node_queue.size() >0){
                    node_queue.addLast(null);
                }
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
