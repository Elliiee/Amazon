import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeIteration {
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    /*
    Time complexity : O(n)
    Because we traverse the entire input tree once,
    the total run time is O(n),
    where nn is the total number of nodes in the tree.

    Space complexity : O(n)
    There is additional space required for the search queue.
    In the worst case, we have to insert O(n) nodes in the queue.
    Therefore, space complexity is O(n).
     */
}
