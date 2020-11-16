package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author zhihua on 2020/11/16
 */
public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
       return inorder(result,root);
    }
    public List<Integer> inorder(List<Integer> r,TreeNode root){
        if(root==null){
            return r;
        }
        inorder(r,root.left);
        r.add(root.val);
        inorder(r,root.right);
        return r;
    }
    public static void main(String []args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(2);
        TreeNode root4 =new TreeNode(2);
        TreeNode root5 =new TreeNode(4);
        TreeNode root6 =new TreeNode(3);
        TreeNode root7 =new TreeNode(3);

//        root1.left=root2;
        root1.right=root3;
//       root2.left=root4;
//       root2.right=root5;
       root3.left=root6;
//       root3.right=root7;
        System.out.println(new Binary_Tree_Inorder_Traversal().inorderTraversal(root1).toString());

    }
}