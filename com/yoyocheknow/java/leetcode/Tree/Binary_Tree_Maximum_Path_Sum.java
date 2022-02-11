package leetcode.Tree;

import dataStructure.TreeNode;

public class Binary_Tree_Maximum_Path_Sum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        backtrack(root);
        return max;
    }

    public int backtrack(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=0;
        int right=0;
        if(root.left!=null){
            left = backtrack(root.left);
        }
        if(root.right!=null){
           right= backtrack(root.right);
        }
        max=Math.max(max,left+root.val);
        max=Math.max(max,right+root.val);
        max=Math.max(max,root.val);
        max=Math.max(max,left+root.val+right);
        return Math.max(root.val,Math.max(left,right)+root.val);
    }
    public static void main(String[] args){
        TreeNode root1 =new TreeNode(-10);
        TreeNode root2 =new TreeNode(9);
        TreeNode root3 =new TreeNode(20);
        TreeNode root4 =new TreeNode(15);
        TreeNode root5 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;

        root3.left=root4;

        root3.right=root5;
        System.out.println(new Binary_Tree_Maximum_Path_Sum().maxPathSum(root1));
    }

}
