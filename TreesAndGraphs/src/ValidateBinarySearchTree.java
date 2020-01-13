import java.util.LinkedList;
import java.util.Stack;

/*
Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null){
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower){
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }

        if (! helper(node.left, lower, val)){
            return false;
        }
        if (! helper(node.right, val, upper)){
            return false;
        }

        return true;
    }

    // Approach 1: Recursion
    public boolean isValidBSTRecursion(TreeNode node){
        return helper(node, null, null);
    }

    /*
    Approach 2: Iteration
    Iteration: DFS
     */
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();

    public void update(TreeNode root, Integer lower, Integer upper){
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBSTIteration(TreeNode root){
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()){
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null){
                continue;
            }

            val = root.val;
            if(lower != null && val <= lower){
                return false;
            }
            if(upper != null && val >= upper){
                return false;
            }
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    public boolean isValidBSTInorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
