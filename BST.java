/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 //SC: O(h) -> height of tree
 //TC: O(n) -> node of tree
 
class Solution {
    TreeNode prev;
    boolean flag;
    
    public boolean isValidBST(TreeNode root) {
        flag=true;
        inorder(root);
        return flag;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        if(flag)
            inorder(root.left); //st.pop() root
        System.out.print("Up");
        System.out.println(root.val);
        
        if(prev!=null && prev.val>=root.val){ //this is to check if the nums are not in sorted way for eg. L=5 Root=7 R=6
            flag=false;
            return;
        }
        prev=root;
        if(flag) //if there is breach in the left sub tree then no need to traverse right side hence this check
            inorder(root.right); //st.pop() root
        System.out.print("Down");
        System.out.println(root.val);
    }
}