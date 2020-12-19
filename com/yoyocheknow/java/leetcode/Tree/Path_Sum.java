package leetcode.Tree;

import dataStructure.TreeNode;

/**
 * 二叉树路径和
 *
 * @author zhihua on 2020/12/19
 */
public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.val == sum && root.left == null && root.right == null){
            return true;
        }

        boolean hasLeft = hasPathSum(root.left, sum - root.val);
        boolean hasRight = hasPathSum(root.right, sum - root.val);

        return hasLeft || hasRight;
    }


    public static void main(String []args){
        TreeNode root1 =new TreeNode(5);
        TreeNode root2 =new TreeNode(4);
        TreeNode root3 =new TreeNode(8);
        TreeNode root4 =new TreeNode(11);
        TreeNode root5 =new TreeNode(13);
        TreeNode root6 =new TreeNode(4);
        TreeNode root7 =new TreeNode(7);
        TreeNode root8 =new TreeNode(2);
        TreeNode root9 =new TreeNode(5);
        TreeNode root10 =new TreeNode(1);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;

        root3.left=root5;
        root3.right=root6;
        root4.left=root7;
        root4.right=root8;
        //root6.left=root9;
        root6.right=root10;
        System.out.println(new Path_Sum().hasPathSum(root1,22));
    }
}