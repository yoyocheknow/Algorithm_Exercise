package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.List;

/**
 * 二叉树转链表
 *
 * @author zhihua on 2020/11/19
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        TreeNode cur =root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode prev = cur.left;
                //当前节点有右子树的话，一直遍历找到最右子节点
                while(prev.right!=null){
                    prev=prev.right;
                }
                //prev目前是cur左子树的最右子节点
                //将cur节点的右子树挂在prev的右节点上
                prev.right = cur.right;
                //cur左子树节点移到右节点
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
    TreeNode last = new TreeNode();
    public void flatten1(TreeNode root) {
        if(root!=null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            last.right=root;
            last.left=null;
            last=root;
            flatten1(left);
            flatten1(right);
        }
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root4 =new TreeNode(4);
        TreeNode root5 =new TreeNode(5);
        TreeNode root6 =new TreeNode(6);
        TreeNode root7 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        root3.right=root7;
        new Flatten_Binary_Tree_to_Linked_List().flatten(root1);
        System.out.println(root1);
    }
}