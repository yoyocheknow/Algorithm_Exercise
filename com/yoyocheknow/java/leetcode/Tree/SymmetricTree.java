package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 镜像二叉树
 *
 * @author zhihua on 2020/11/16
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
       if(root==null){
           return true;
       }
       return isSame(root.left,root.right);

    }

    public boolean isSame(TreeNode left,TreeNode right) {

        if(left!=null && right!=null){
            if(left.val==right.val){
                return isSame(left.left,right.right) && isSame(left.right,right.left);
            }else{
                return false;
            }
        }else if(left==null && right==null){
            return true;
        }else{
            return false;
        }

    }

   public static void main(String []args){
       TreeNode root1 =new TreeNode(1);
       TreeNode root2 =new TreeNode(2);
       TreeNode root3 =new TreeNode(2);
       TreeNode root4 =new TreeNode(3);
       TreeNode root5 =new TreeNode(4);
       TreeNode root6 =new TreeNode(4);
       TreeNode root7 =new TreeNode(3);

       root1.left=root2;
       root1.right=root3;
       root2.left=root4;
       root2.right=root5;
       root3.left=root6;
       root3.right=root7;
       System.out.println(new SymmetricTree().isSymmetric(root1));

   }
}