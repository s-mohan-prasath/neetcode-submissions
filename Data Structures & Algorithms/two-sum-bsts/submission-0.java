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

class Solution {
    public boolean twoSumBSTs(TreeNode r1, TreeNode r2, int t) {
        if(r1==null)return false;
        else{
            if(find(r2,t-r1.val))return true;
            else return twoSumBSTs(r1.left,r2,t) || twoSumBSTs(r1.right,r2,t);
        }   
    }
    private boolean find(TreeNode r,int t){
        if(r==null)return false;
        else{
            if(r.val==t)return true;
            else if(r.val<t)return find(r.right,t);
            else return find(r.left,t);
        }
    }
}
