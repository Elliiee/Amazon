import java.util.LinkedList;
import java.util.Queue;

/*
Symmetric Tree
Given a binary tree,
check whether it is a mirror of itself (ie, symmetric around its center).
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetricRecursion(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
    /*
    Time Complexity: O(n). because we traverse the entire tree
    Space Complexity: the number of recursive calls is bound by the height of the tree.
    In the worst case, the tree is linear and the height is O(n).
     */

    /*
    We can use iteration with the aid of a queue.
    Each two consecutive nodes in the queue should be equal,
    and their subtrees are the mirror of each other.
     */

    public boolean isSymmetricIteration(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if(t1.val != t2.val){
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
}
