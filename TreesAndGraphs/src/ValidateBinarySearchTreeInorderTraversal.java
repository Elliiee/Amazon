import java.util.Stack;

/*
Validate Binary Search Tree
Inorder Traversal
 */
public class ValidateBinarySearchTreeInorderTraversal {
    public boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE; // NOTE: this is negative

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left; // this is a loop, so it will keep adding the left child
            }
            root = stack.pop();
            if (root.val <= inorder)  return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

/*
For BST, inorder traversal means each element should be smaller than the next one.
And also, we don't need to keep the whole list of inorder nodes, we only need the
last added element.
 */
