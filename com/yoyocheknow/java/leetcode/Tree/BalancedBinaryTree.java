package leetcode.Tree;

import dataStructure.TreeNode;

/**
 * 平衡二叉树
 *
 * @author zhihua on 2020/11/15
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)<=1 &&isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }
    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1+Math.max(leftHeight, rightHeight);
    }

    public static void main(String args[]){
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root4 =new TreeNode(4);
        TreeNode root5 =new TreeNode(5);
        TreeNode root6 =new TreeNode(6);
        TreeNode root7 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
//        root2.left=root4;
//        root2.right=root5;
//        root4.left=root6;
//        root4.right=root7;

        System.out.println(bbt.isBalanced(root1));
    }
}