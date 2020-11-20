package leetcode.Tree;

import dataStructure.TreeNode;

/**
 * 判断两棵树是否相等
 *
 * @author zhihua on 2020/11/20
 */
public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String []args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);

        TreeNode root4 =new TreeNode(1);
        TreeNode root5 =new TreeNode(2);
        TreeNode root6 =new TreeNode(3);


        root1.left=root2;
        root1.right=root3;



        root4.left=root5;
        root4.right=root6;

        System.out.println(new Same_Tree().isSameTree(root1,root4));
    }
}