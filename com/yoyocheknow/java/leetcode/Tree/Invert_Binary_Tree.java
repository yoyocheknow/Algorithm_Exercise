package leetcode.Tree;

import dataStructure.ListNode;
import dataStructure.TreeNode;

import java.util.TreeMap;

/**
 * 翻转二叉树
 *
 * @author zhihua on 2021/1/19
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
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

        TreeNode root = new Invert_Binary_Tree().invertTree(root1);
        Inorder(root);
    }

    public static void Inorder(TreeNode root){
        if(root.left!=null){
            Inorder(root.left);
        }

        System.out.println(root.val);
        if(root.right!=null){
            Inorder(root.right);
        }

    }
}