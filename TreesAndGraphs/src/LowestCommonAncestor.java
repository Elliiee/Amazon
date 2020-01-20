public class LowestCommonAncestor{
    private TreeNode ans;
    public LowestCommonAncestor(){
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){
        if (currentNode == null) return false; // reached the end of a branch (without node found)

        // left recursion: set left = 1 otherwise 0 if it returns true;
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // right recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // create a variable mid and mark it as 1 if one of the value has been found
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // if any two of the flags become true, add the current node as answer
        if (mid + left + right >= 2)
            this.ans = currentNode;

        // return true if any one of the three boolean value is true
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.recurseTree(root, p, q);
        return this.ans;
    }
}