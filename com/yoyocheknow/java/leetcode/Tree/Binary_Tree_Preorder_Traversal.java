package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 *
 * @author zhihua on 2021/1/26
 */
public class Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root4 =new TreeNode(4);
        TreeNode root5 =new TreeNode(5);

        root1.left=root2;
        root1.right=root3;

        root2.left=root4;

        root2.right=root5;
        System.out.println(new Binary_Tree_Preorder_Traversal().preorderTraversal(root1).toString());
    }

}